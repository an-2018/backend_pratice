package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.powersolutioncv.tryon.samples.resthateoas.models.Greeting
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
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
        
        val greeting = Greeting(String.format(TEMPLATE, name))
        greeting.add(linkTo(methodOn(GreetingController::class.java).greeting(name!!)).withSelfRel())

        return ResponseEntity(greeting, HttpStatus.OK)
    }
}