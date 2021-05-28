package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.powersolutioncv.tryon.samples.resthateoas.Exceptions.UserNotFoundException
import com.powersolutioncv.tryon.samples.resthateoas.models.User
import org.springframework.context.annotation.Bean
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
interface RestController<T> {

    @GetMapping
    fun all(): CollectionModel<EntityModel<T>>

    @PostMapping
    fun create(@RequestBody entity: T): ResponseEntity<EntityModel<T>>

    @GetMapping("/{id}")
    fun one(@PathVariable id: Long): EntityModel<T>

    @PutMapping("/{id}")
    fun update(@RequestBody newUser: User, @PathVariable id:Long): ResponseEntity<EntityModel<T>>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long)
}
