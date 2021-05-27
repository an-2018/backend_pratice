package com.powersolutioncv.tryon.samples.resthateoas.models.Samples
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.RepresentationModel;

class Greeting @JsonCreator constructor(@param:JsonProperty("content") val content: String) :
    RepresentationModel<Greeting?>()