package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.powersolutioncv.tryon.samples.resthateoas.Exceptions.UserNotFoundException
import com.powersolutioncv.tryon.samples.resthateoas.dao.UserRepository
import com.powersolutioncv.tryon.samples.resthateoas.models.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val repository: UserRepository){

    @GetMapping("")
    fun all(): List<User>{

        return repository.findAll()
    }

    @PostMapping("")
    fun newUser(@RequestBody user:User): User{

        return repository.save(user)
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: Long):Any{

        return repository.findById(id)
            .orElseThrow { UserNotFoundException(id) }
    }

    @PutMapping("/{id}")
    fun replaceUser(@RequestBody newUser: User, @PathVariable id:Long): User{

        return repository.findById(id)
            .map{ user:User ->
                user.name = newUser.name
                user.role = newUser.role
                repository.save(user)
            }
            .orElseGet{
                newUser.id = id
                repository.save(newUser)
            }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long){

        repository.deleteById(id)
    }
}