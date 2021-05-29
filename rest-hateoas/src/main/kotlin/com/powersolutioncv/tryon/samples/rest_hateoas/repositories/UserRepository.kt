package com.powersolutioncv.tryon.samples.rest_hateoas.repositories

import com.powersolutioncv.tryon.samples.rest_hateoas.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>