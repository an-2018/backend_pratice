package com.powersolutioncv.tryon.samples.resthateoas.helpers

import com.powersolutioncv.tryon.samples.resthateoas.models.ModelEntity
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler

class UserModelAssembler<T:ModelEntity>: RepresentationModelAssembler<T, EntityModel<T>> {

    override fun toModel(entity: T): EntityModel<T> {
        TODO()
    }
}
