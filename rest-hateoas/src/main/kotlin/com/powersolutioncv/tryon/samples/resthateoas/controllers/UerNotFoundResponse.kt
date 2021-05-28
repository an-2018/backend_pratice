package com.powersolutioncv.tryon.samples.resthateoas.controllers

import com.powersolutioncv.tryon.samples.resthateoas.Exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class UerNotFoundResponse {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun userNotFoundHandler(ex: UserNotFoundException): String? {

        return ex.message
    }
}
