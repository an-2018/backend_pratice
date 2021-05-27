package com.powersolutioncv.tryon.samples.resthateoas.controllers.samples

import com.powersolutioncv.tryon.samples.resthateoas.models.Samples.Greeting
import com.powersolutioncv.tryon.samples.resthateoas.services.PersonService
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {
    companion object Create {
        val TEMPLATE = "Hello, %s"
    }

    var message: List<String> = listOf("Hello", "Hi", "By")

    @RequestMapping("/greeting")
    fun greeting(
        @RequestParam(value = "name", defaultValue = "World")
        name: String?
    ): HttpEntity<Greeting> {

        val person = PersonService().getPerson()
        val linkToPeople: Link = linkTo(PersonService::class.java).slash(person).withRel("people")

        val linkToMethod = linkTo(methodOn(GreetingController::class.java).greeting(name!!)).withSelfRel()
        val greeting = Greeting(String.format(TEMPLATE, name))

        greeting.add(linkToMethod)
        greeting.add(linkToPeople)
        // greeting.add(linkTo(methodOn(GreetingController::class.java).greeting(name!!)).withSelfRel())

        return ResponseEntity(greeting, HttpStatus.OK)
    }
}