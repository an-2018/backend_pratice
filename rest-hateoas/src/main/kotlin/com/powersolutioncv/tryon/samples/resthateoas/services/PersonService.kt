package com.powersolutioncv.tryon.samples.resthateoas.services

import com.powersolutioncv.tryon.samples.resthateoas.models.Samples.Person


open class PersonService {

    fun getPerson(id:Int = 0) = getPersons()[id]

    fun getPersons() = listOf(
        Person(id = "http://example.com/person/1234", name = "John Doe"),
        Person(id = "http://example.com/person/1235", name = "Mary Smith")
    )
}