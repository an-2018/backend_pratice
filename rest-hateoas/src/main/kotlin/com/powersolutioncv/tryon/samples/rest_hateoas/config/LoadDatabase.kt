package com.powersolutioncv.tryon.samples.rest_hateoas.config

import com.powersolutioncv.tryon.samples.rest_hateoas.repositories.UserRepository
import com.powersolutioncv.tryon.samples.rest_hateoas.models.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {

    companion object{
        private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)
    }

    @Bean
    fun initDatabase(repository: UserRepository): CommandLineRunner? {

        return CommandLineRunner { args: Array<String?>? ->
            log.info("Preloading " + repository.save(User(name = "Bilbo Baggins", role = "Tourist")))
            log.info("Preloading " + repository.save(User(name = "Frodo Baggins", role = "Provider")))
        }
    }
}
