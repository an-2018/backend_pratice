package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.powersolutioncv.tryon.samples.resthateoas.Exceptions.UserNotFoundException
import com.powersolutioncv.tryon.samples.resthateoas.dao.UserRepository
import com.powersolutioncv.tryon.samples.resthateoas.helpers.UserModelAssembler
import com.powersolutioncv.tryon.samples.resthateoas.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/users")
class UserController(): RestController<User>{
    @Autowired
    private lateinit var repository: UserRepository


    override fun all(): CollectionModel<EntityModel<User>>{
        val users: List<EntityModel<User>> = repository.findAll()
                                            .map(this::toModel)
                                            .toList()

        return CollectionModel.of(
                    users,
                    linkTo(methodOn(UserController::class.java).all()).withSelfRel()
                )
    }

    override fun create(user: User): ResponseEntity<EntityModel<User>> {
        val entityModel = this.toModel(repository.save(user))

        return ResponseEntity
            .created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
            )
            .body(entityModel)
    }

    override fun one(@PathVariable id: Long): EntityModel<User> {
        val user = repository.findById(id)
            .orElseThrow { UserNotFoundException(id) }

        return this.toModel(user)
    }


    override fun update(newUser: User, id: Long): ResponseEntity<EntityModel<User>> {

        val updatedUser = repository.findById(id)
            .map{ user:User ->
                user.name = newUser.name
                user.role = newUser.role
                repository.save(user)
            }
            .orElseGet{
                repository.save(newUser)
            }

        val entityModel = this.toModel(updatedUser)

        return ResponseEntity
            .created(
                entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
            )
            .body(entityModel)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun toModel(entity: User): EntityModel<User> {

        return EntityModel.of(
            entity,
            linkTo(methodOn(this::class.java).one(entity.id)).withSelfRel(),
            linkTo(methodOn(this::class.java).all()).withRel("users")
        )
    }
}
