package com.powersolutioncv.tryon.samples.resthateoas.dao

import com.powersolutioncv.tryon.samples.resthateoas.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>