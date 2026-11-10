package com.krish.realtimetaskboard.ui.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.databinding.ItemKanbanCardBinding

class KanbanAdapter : ListAdapter<Task, KanbanAdapter.KanbanViewHolder>(KanbanDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanbanViewHolder {
        val binding = ItemKanbanCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KanbanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KanbanViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class KanbanViewHolder(private val binding: ItemKanbanCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvKanbanTaskKey.text = task.key
            binding.tvKanbanTitle.text = task.title
            binding.tvKanbanDesc.text = task.description
            binding.tvKanbanDueDate.text = task.dueDate
            binding.tvKanbanAssignee.text = task.assigneeInitials
            binding.tvKanbanPriority.text = task.priority.name
        }
    }

    class KanbanDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem
    }
}
