package com.projeto.surtr.entities

import com.projeto.surtr.enums.StatusEnum
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var lastname: String,
    val email: String,
    var password: String,
    val cpf: String,
    val idChat: String,
    @Enumerated(EnumType.STRING)
    var isActive: StatusEnum
)