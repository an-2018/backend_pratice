package com.powersolutioncv.tryon.samples.resthateoas.models

import ioinformarics.oss.jackson.module.jsonld.annotation.*


@JsonldResource // represent a JSON-LD resource
@JsonldNamespace(name = "schema", uri = "http://schema.org/") // schema standard schema for the field definitions
@JsonldType("schema:Person") // type of the resource
@JsonldLink(rel = "schema:knows", name = "knows", href = "http://exmample.com/person/2334") //
data class Person constructor(@JsonldId val id: String, @JsonldProperty("schema:name") val name:String) {}

