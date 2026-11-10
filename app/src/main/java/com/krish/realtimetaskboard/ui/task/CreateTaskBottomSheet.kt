package com.krish.realtimetaskboard.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.krish.realtimetaskboard.data.model.Task
import com.krish.realtimetaskboard.data.model.TaskPriority
import com.krish.realtimetaskboard.data.model.TaskStatus
import com.krish.realtimetaskboard.databinding.DialogCreateTaskBinding
import com.krish.realtimetaskboard.viewmodel.TaskBoardViewModel
import androidx.fragment.app.viewModels

class CreateTaskBottomSheet : BottomSheetDialogFragment() {

    private var _binding: DialogCreateTaskBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TaskBoardViewModel by viewModels({ requireActivity() })

    private var selectedStatus = TaskStatus.IN_PROGRESS
    private var selectedPriority = TaskPriority.HIGH

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogCreateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCloseDialog.setOnClickListener {
            dismiss()
        }

        binding.btnStatusTodo.setOnClickListener { selectedStatus = TaskStatus.TODO }
        binding.btnStatusInProgress.setOnClickListener { selectedStatus = TaskStatus.IN_PROGRESS }
        binding.btnStatusDone.setOnClickListener { selectedStatus = TaskStatus.COMPLETED }

        binding.btnPriorityLow.setOnClickListener { selectedPriority = TaskPriority.LOW }
        binding.btnPriorityMedium.setOnClickListener { selectedPriority = TaskPriority.MEDIUM }
        binding.btnPriorityHigh.setOnClickListener { selectedPriority = TaskPriority.HIGH }

        binding.btnSubmitTask.setOnClickListener {
            val title = binding.etTaskTitle.text?.toString()?.trim() ?: ""
            val desc = binding.etTaskDesc.text?.toString()?.trim() ?: ""

            if (title.isEmpty()) {
                binding.etTaskTitle.error = "Please enter task title"
                return@setOnClickListener
            }

            val newTask = Task(
                id = "t_${System.currentTimeMillis()}",
                key = "DEV-${(100..999).random()}",
                title = title,
                description = desc,
                status = selectedStatus,
                priority = selectedPriority,
                dueDate = "Due Today",
                assigneeName = "Alex Chen",
                assigneeInitials = "AC",
                assigneeAvatarUrl = null,
                tags = listOf("#mobile", "#native"),
                subtasksCompleted = 0,
                subtasksTotal = 3,
                commentsCount = 0
            )

            viewModel.addTask(newTask)
            Toast.makeText(requireContext(), "Task created successfully!", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
