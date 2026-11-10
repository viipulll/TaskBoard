package com.krish.realtimetaskboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krish.realtimetaskboard.data.model.ActivityItem
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.data.model.TaskStatus
import com.krish.realtimetaskboard.data.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class TaskBoardViewModel : ViewModel() {
    private val repository = TaskRepository.getInstance()

    val tasks: StateFlow<List<Task>> = repository.tasks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activities: StateFlow<List<ActivityItem>> = repository.activities
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(task: Task) {
        repository.addTask(task)
    }

    fun updateTaskStatus(taskId: String, status: TaskStatus) {
        repository.updateTaskStatus(taskId, status)
    }
}
