package com.krish.realtimetaskboard.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.data.model.TaskStatus
import com.krish.realtimetaskboard.databinding.ItemTaskBinding

class TaskAdapter : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTaskTitle.text = task.title
            binding.tvTaskDueDate.text = task.dueDate
            binding.tvAssigneeInitials.text = task.assigneeInitials

            when (task.status) {
                TaskStatus.TODO -> {
                    binding.tvTaskStatusBadge.text = "To Do"
                }
                TaskStatus.IN_PROGRESS -> {
                    binding.tvTaskStatusBadge.text = "In Progress"
                }
                TaskStatus.COMPLETED -> {
                    binding.tvTaskStatusBadge.text = "Completed"
                }
            }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem
    }
}
