package com.krish.realtimetaskboard.data.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val role: String,
    val workspace: String,
    val avatarUrl: String?
)
