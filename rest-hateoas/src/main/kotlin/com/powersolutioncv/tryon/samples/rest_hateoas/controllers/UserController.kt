package com.powersolutioncv.tryon.samples.rest_hateoas.controllers

import com.powersolutioncv.tryon.samples.rest_hateoas.Exceptions.UserNotFoundException
import com.powersolutioncv.tryon.samples.rest_hateoas.helpers.UserModelAssembler
import com.powersolutioncv.tryon.samples.rest_hateoas.models.User
import com.powersolutioncv.tryon.samples.rest_hateoas.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(): RestControllerInt<User>{

    @Autowired
    private lateinit var repository: UserRepository
    @Autowired
    private lateinit var assembler: UserModelAssembler

    override fun all(): CollectionModel<EntityModel<User>>{
        val users: List<EntityModel<User>> = repository.findAll()
            .map(assembler::toModel)
            .toList()

        return CollectionModel.of(
            users,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController::class.java).all()).withSelfRel()
        )
    }

    override fun create(@RequestBody entity: User): ResponseEntity<EntityModel<User>>{
        val entityModel = assembler.toModel(repository.save(entity))

        return ResponseEntity
            .created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
            )
            .body(entityModel)
    }

    override fun one(@PathVariable id: Long): EntityModel<User>{
        val user = repository.findById(id)
            .orElseThrow { UserNotFoundException(id) }

        return assembler.toModel(user)
    }

    override fun update(@RequestBody newEntity: User, @PathVariable id:Long): ResponseEntity<EntityModel<User>>{

        val updatedUser = repository.findById(id)
            .map{ user:User ->
                user.name = newEntity.name
                user.role = newEntity.role
                repository.save(user)
            }
            .orElseGet{
                repository.save(newEntity)
            }

        val entityModel = assembler.toModel(updatedUser)

        return ResponseEntity
            .created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
            )
            .body(entityModel)
    }

    override fun delete(@PathVariable id: Long){

        repository.deleteById(id)
    }
}