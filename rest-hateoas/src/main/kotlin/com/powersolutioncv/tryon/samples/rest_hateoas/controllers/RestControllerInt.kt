package com.powersolutioncv.tryon.samples.rest_hateoas.controllers

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

interface RestControllerInt<T> {

    @GetMapping
    fun all(): CollectionModel<EntityModel<T>>

    @PostMapping
    fun create(@RequestBody entity: T): ResponseEntity<EntityModel<T>>

    @GetMapping("/{id}")
    fun one(@PathVariable id: Long): EntityModel<T>

    @PutMapping("/{id}")
    fun update(@RequestBody newEntity: T, @PathVariable id:Long): ResponseEntity<EntityModel<T>>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long)
}
