package com.powersolutioncv.tryon.samples.resthateoas.controllers.samples

import com.fasterxml.jackson.databind.ObjectMapper
import com.powersolutioncv.tryon.samples.resthateoas.services.PersonService
import ioinformarics.oss.jackson.module.jsonld.JsonldModule

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/person")
class PersonController {

    val personService = PersonService()

    @RequestMapping(method = [RequestMethod.GET],value = [""])
    fun getPersons(): HttpEntity<String> {

        val persons = Collections.singleton(personService.getPersons())

        return ResponseEntity(jsonLdMapper(persons), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.GET], value = ["/{id}"])
    fun getPeron(@PathVariable id: Int): HttpEntity<String>{

        val person = personService.getPerson(id)

        return ResponseEntity(jsonLdMapper(person), HttpStatus.OK)
    }

    fun jsonLdMapper(value: Any):String =

        ObjectMapper().apply {
            registerModule(JsonldModule())
        }.writeValueAsString(value)
}