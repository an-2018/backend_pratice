package com.powersolutioncv.tryon.samples.rest_hateoas.repositories

import com.powersolutioncv.tryon.samples.rest_hateoas.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>