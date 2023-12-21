package com.projeto.surtr.controllers

import com.projeto.surtr.entities.User
import com.projeto.surtr.services.UserService
import jakarta.validation.Valid
import lombok.AllArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@AllArgsConstructor
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @PostMapping
    fun register(@RequestBody @Valid user: User): ResponseEntity<User> {
        service.save(user)
        return ResponseEntity.status(201).body(user)
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PostMapping("/active/{id}")
    fun activeUser(@PathVariable id: Long): ResponseEntity<Void> {
        service.activeStatus(id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/disable/{id}")
    fun disableUser(@PathVariable id: Long): ResponseEntity<Void> {
        service.disableStatus(id)
        return ResponseEntity.ok().build()
    }
}