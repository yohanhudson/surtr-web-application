package com.projeto.surtr.services

import com.projeto.surtr.entities.User
import com.projeto.surtr.enums.StatusEnum
import com.projeto.surtr.repositories.UserRepository
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class UserService(private val repository: UserRepository) {

    fun save(user: User) {
        repository.save(user)
    }

    fun findById(id: Long): User {
        return repository.findById(id).get()
    }

    fun activeStatus(id: Long) {
        findById(id).isActive = StatusEnum.Active
    }

    fun disableStatus(id: Long) {
        findById(id).isActive = StatusEnum.DISABLED
    }
}