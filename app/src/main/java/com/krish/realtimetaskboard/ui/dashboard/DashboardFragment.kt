package com.krish.realtimetaskboard.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.krish.realtimetaskboard.data.model.TaskStatus
import com.krish.realtimetaskboard.databinding.FragmentDashboardBinding
import com.krish.realtimetaskboard.ui.task.CreateTaskBottomSheet
import com.krish.realtimetaskboard.viewmodel.TaskBoardViewModel
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TaskBoardViewModel by activityViewModels()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskAdapter = TaskAdapter()
        binding.rvRecentTasks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }

        binding.fabAddTask.setOnClickListener {
            CreateTaskBottomSheet().show(parentFragmentManager, "CreateTaskBottomSheet")
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.tasks.collect { tasks ->
                    binding.tvStatTotal.text = tasks.size.toString()
                    binding.tvStatInProgress.text = tasks.count { it.status == TaskStatus.IN_PROGRESS }.toString()
                    binding.tvStatCompleted.text = tasks.count { it.status == TaskStatus.COMPLETED }.toString()
                    binding.tvStatOverdue.text = "3" // sample overdue count

                    taskAdapter.submitList(tasks.take(5))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
