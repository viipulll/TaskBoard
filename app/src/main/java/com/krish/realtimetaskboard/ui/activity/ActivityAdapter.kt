package com.krish.realtimetaskboard.ui.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.krish.realtimetaskboard.data.model.ActivityItem
import com.krish.realtimetaskboard.databinding.ItemActivityBinding

class ActivityAdapter : ListAdapter<ActivityItem, ActivityAdapter.ActivityViewHolder>(ActivityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ActivityViewHolder(private val binding: ItemActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ActivityItem) {
            binding.tvActivityInitials.text = item.userInitials
            binding.tvActivityDescription.text = "${item.userName} ${item.action} ${item.target}"
            binding.tvActivityTimestamp.text = item.timestamp
        }
    }

    class ActivityDiffCallback : DiffUtil.ItemCallback<ActivityItem>() {
        override fun areItemsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean = oldItem == newItem
    }
}
