package com.krish.realtimetaskboard.data.model

data class ActivityItem(
    val id: String,
    val userName: String,
    val userInitials: String,
    val action: String,
    val target: String,
    val timestamp: String,
    val avatarUrl: String?
)
