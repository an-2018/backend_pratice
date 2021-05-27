package com.powersolutioncv.tryon.samples.resthateoas.Exceptions

class UserNotFoundException(id: Long): RuntimeException("Could not find employee with id: $id")