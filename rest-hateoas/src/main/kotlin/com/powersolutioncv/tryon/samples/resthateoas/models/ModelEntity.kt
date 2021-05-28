package com.powersolutioncv.tryon.samples.resthateoas.models

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
open class ModelEntity {

    @Id
    @GeneratedValue
    var id: Long = 0L
    get() {
        return field
    }
}


