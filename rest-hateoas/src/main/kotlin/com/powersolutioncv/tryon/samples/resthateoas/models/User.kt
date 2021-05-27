package com.powersolutioncv.tryon.samples.resthateoas.models

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
data class User(
    @Id
    @GeneratedValue
    var id: Long=0L,
    var name:String = "",
    var role: String = ""
)