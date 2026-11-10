package com.krish.realtimetaskboard.data.repository

import com.krish.realtimetaskboard.data.model.ActivityItem
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.utils.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskRepository {
    private val _tasks = MutableStateFlow(SampleData.tasks)
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _activities = MutableStateFlow(SampleData.activities)
    val activities: StateFlow<List<ActivityItem>> = _activities.asStateFlow()

    fun addTask(task: Task) {
        val currentList = _tasks.value.toMutableList()
        currentList.add(0, task)
        _tasks.value = currentList

        // Add corresponding activity
        val newActivity = ActivityItem(
            id = "a_${System.currentTimeMillis()}",
            userName = task.assigneeName,
            userInitials = task.assigneeInitials,
            action = "created new task",
            target = "${task.key} ${task.title}",
            timestamp = "Just now",
            avatarUrl = null
        )
        val actList = _activities.value.toMutableList()
        actList.add(0, newActivity)
        _activities.value = actList
    }

    fun updateTaskStatus(taskId: String, newStatus: com.krish.realtimetaskboard.data.model.TaskStatus) {
        val currentList = _tasks.value.map { task ->
            if (task.id == taskId) {
                task.copy(status = newStatus)
            } else {
                task
            }
        }
        _tasks.value = currentList
    }

    companion object {
        @Volatile
        private var instance: TaskRepository? = null

        fun getInstance(): TaskRepository {
            return instance ?: synchronized(this) {
                instance ?: TaskRepository().also { instance = it }
            }
        }
    }
}
