package com.powersolutioncv.tryon.samples.resthateoas.models

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue

data class User(

    var name:String = "",
    var role: String = ""
): ModelEntity()
