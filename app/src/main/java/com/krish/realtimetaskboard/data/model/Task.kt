package com.krish.realtimetaskboard.data.model

data class Task(
    val id: String,
    val key: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val priority: TaskPriority,
    val dueDate: String,
    val assigneeName: String,
    val assigneeInitials: String,
    val assigneeAvatarUrl: String?,
    val tags: List<String>,
    val subtasksCompleted: Int = 0,
    val subtasksTotal: Int = 0,
    val commentsCount: Int = 0
)

enum class TaskStatus {
    TODO, IN_PROGRESS, COMPLETED
}

enum class TaskPriority {
    LOW, MEDIUM, HIGH
}
