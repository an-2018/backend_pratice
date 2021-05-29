package com.powersolutioncv.tryon.samples.rest_hateoas.helpers

import com.powersolutioncv.tryon.samples.rest_hateoas.controllers.UserController
import com.powersolutioncv.tryon.samples.rest_hateoas.models.User
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*
import org.springframework.stereotype.Component

@Component
class UserModelAssembler: RepresentationModelAssembler<User, EntityModel<User>> {

    override fun toModel(entity: User): EntityModel<User> {

        return EntityModel.of(
            entity,
           linkTo(methodOn(UserController::class.java).one(entity.id)).withSelfRel(),
           linkTo(methodOn(UserController::class.java).all()).withRel("users")
        )
    }
}
