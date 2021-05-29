package com.powersolutioncv.tryon.samples.rest_hateoas.Exceptions

class UserNotFoundException(id: Long): RuntimeException("Could not find employee with id: $id")