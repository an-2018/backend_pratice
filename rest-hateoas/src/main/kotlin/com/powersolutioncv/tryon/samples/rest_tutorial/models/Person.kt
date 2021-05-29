package com.powersolutioncv.tryon.samples.rest_tutorial.models

import ioinformarics.oss.jackson.module.jsonld.annotation.*


@JsonldResource // represent a JSON-LD resource
@JsonldNamespace(name = "s", uri = "http://schema.org/") // schema standard schema for the field definitions
@JsonldType("s:Person") // type of the resource
@JsonldLink(rel = "s:knows", name = "knows", href = "http://exmample.com/person/2334") //
data class Person1(@JsonldId val id: String, @JsonldProperty("s:name") val name:String)

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://schema.org/")
@JsonldType("s:Person")
@JsonldLink(rel = "s:knows", name = "knows", href = "http://example.com/person/2345")
data class Person (
    @JsonldId
    val id: String? = null,

    @JsonldProperty("s:name")
    val name: String? = null // constructor, getters, setters
)