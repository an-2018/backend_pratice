package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.powersolutioncv.tryon.samples.resthateoas.models.Person
import ioinformarics.oss.jackson.module.jsonld.JsonldModule
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
class PersonController {

    val persons = listOf(
        Person(id = "http://example.com/person/1234", name = "John Doe"),
        Person(id = "http://example.com/person/1235", name = "Mary Smith")
    )
    @RequestMapping(method = [RequestMethod.GET],value = ["/person"])
    fun getPerson(): HttpEntity<String> {

        val person = Person(id = "http://example.com/person/1234", name="John Doe")
        println(person.toString())

        return ResponseEntity(jsonLdMapper(person), HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.GET], value = ["/person/{id}"])
    fun setCurrent(@PathVariable id: Int): HttpEntity<String>{

        val person = persons[id] ?: "None"

        return ResponseEntity(jsonLdMapper(person), HttpStatus.OK)
    }

    fun jsonLdMapper(value: Any):String {
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JsonldModule())

        return objectMapper.writeValueAsString(value)
    }
}