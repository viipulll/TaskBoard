package com.krish.realtimetaskboard.utils

import com.krish.realtimetaskboard.data.model.ActivityItem
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.data.model.TaskPriority
import com.krish.realtimetaskboard.data.model.TaskStatus
import com.krish.realtimetaskboard.data.model.User

object SampleData {
    val currentUser = User(
        id = "usr_001",
        name = "Alex Chen",
        email = "alex.chen@company.com",
        role = "Product Manager • Mobile Squad",
        workspace = "Sprint Alpha",
        avatarUrl = null
    )

    val tasks = listOf(
        Task(
            id = "t1",
            key = "DEV-104",
            title = "Setup Cloud Firestore Indexes",
            description = "Optimize compound queries for task filters and real-time subscriber latency.",
            status = TaskStatus.TODO,
            priority = TaskPriority.HIGH,
            dueDate = "Oct 24",
            assigneeName = "Alex Chen",
            assigneeInitials = "AC",
            assigneeAvatarUrl = null,
            tags = listOf("#backend", "#database"),
            subtasksCompleted = 0,
            subtasksTotal = 3,
            commentsCount = 2
        ),
        Task(
            id = "t2",
            key = "DS-209",
            title = "Review Material 3 tokens",
            description = "Ensure dark/light contrast compliance and accessibility on high DPI devices.",
            status = TaskStatus.TODO,
            priority = TaskPriority.MEDIUM,
            dueDate = "Oct 26",
            assigneeName = "Sarah Roy",
            assigneeInitials = "SR",
            assigneeAvatarUrl = null,
            tags = listOf("#design-system"),
            subtasksCompleted = 1,
            subtasksTotal = 4,
            commentsCount = 1
        ),
        Task(
            id = "t3",
            key = "KOT-88",
            title = "Implement Real-time Sync",
            description = "Listen to task snapshot changes in Kotlin Coroutines stateFlow pipeline.",
            status = TaskStatus.IN_PROGRESS,
            priority = TaskPriority.HIGH,
            dueDate = "Due Today",
            assigneeName = "Alex Chen",
            assigneeInitials = "AC",
            assigneeAvatarUrl = null,
            tags = listOf("#kotlin", "#sync"),
            subtasksCompleted = 3,
            subtasksTotal = 5,
            commentsCount = 4
        ),
        Task(
            id = "t4",
            key = "DEV-112",
            title = "Push Notifications Integration",
            description = "FCM push handlers for instant task assignment notifications and mentions.",
            status = TaskStatus.IN_PROGRESS,
            priority = TaskPriority.MEDIUM,
            dueDate = "Oct 25",
            assigneeName = "Marcus Vance",
            assigneeInitials = "MV",
            assigneeAvatarUrl = null,
            tags = listOf("#fcm", "#native"),
            subtasksCompleted = 2,
            subtasksTotal = 3,
            commentsCount = 0
        ),
        Task(
            id = "t5",
            key = "AUTH-42",
            title = "User Registration flow",
            description = "Email validation and password strength check with automated regression tests.",
            status = TaskStatus.COMPLETED,
            priority = TaskPriority.HIGH,
            dueDate = "Yesterday",
            assigneeName = "Elena Rostova",
            assigneeInitials = "ER",
            assigneeAvatarUrl = null,
            tags = listOf("#auth"),
            subtasksCompleted = 5,
            subtasksTotal = 5,
            commentsCount = 6
        ),
        Task(
            id = "t6",
            key = "UI-015",
            title = "Bottom Navigation bar & transitions",
            description = "Implement M3 bottom nav with smooth fragment transitions and state restoration.",
            status = TaskStatus.COMPLETED,
            priority = TaskPriority.MEDIUM,
            dueDate = "2 days ago",
            assigneeName = "Alex Chen",
            assigneeInitials = "AC",
            assigneeAvatarUrl = null,
            tags = listOf("#ui", "#compose-alt"),
            subtasksCompleted = 4,
            subtasksTotal = 4,
            commentsCount = 2
        )
    )

    val activities = listOf(
        ActivityItem(
            id = "a1",
            userName = "Sarah Roy",
            userInitials = "SR",
            action = "pushed 3 commits to",
            target = "Sprint Alpha • KOT-88",
            timestamp = "14m ago",
            avatarUrl = null
        ),
        ActivityItem(
            id = "a2",
            userName = "Marcus Vance",
            userInitials = "MV",
            action = "moved task",
            target = "DEV-112 to In Progress",
            timestamp = "1h ago",
            avatarUrl = null
        ),
        ActivityItem(
            id = "a3",
            userName = "Elena Rostova",
            userInitials = "ER",
            action = "completed task",
            target = "AUTH-42 User Registration flow",
            timestamp = "3h ago",
            avatarUrl = null
        ),
        ActivityItem(
            id = "a4",
            userName = "Alex Chen",
            userInitials = "AC",
            action = "created new task",
            target = "DEV-104 Setup Cloud Firestore Indexes",
            timestamp = "Yesterday",
            avatarUrl = null
        )
    )
}
