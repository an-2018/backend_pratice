package com.powersolutioncv.tryon.samples.rest_hateoas.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue
    val id: Long = 0L,
    var name:String = "",
    var role: String = ""
)
