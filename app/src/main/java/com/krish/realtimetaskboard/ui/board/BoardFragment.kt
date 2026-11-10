package com.krish.realtimetaskboard.ui.board

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
import com.krish.realtimetaskboard.databinding.FragmentBoardBinding
import com.krish.realtimetaskboard.ui.task.CreateTaskBottomSheet
import com.krish.realtimetaskboard.viewmodel.TaskBoardViewModel
import kotlinx.coroutines.launch

class BoardFragment : Fragment() {

    private var _binding: FragmentBoardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TaskBoardViewModel by activityViewModels()

    private lateinit var todoAdapter: KanbanAdapter
    private lateinit var inProgressAdapter: KanbanAdapter
    private lateinit var completedAdapter: KanbanAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoAdapter = KanbanAdapter()
        inProgressAdapter = KanbanAdapter()
        completedAdapter = KanbanAdapter()

        binding.rvColumnTodo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = todoAdapter
        }
        binding.rvColumnInProgress.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = inProgressAdapter
        }
        binding.rvColumnCompleted.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = completedAdapter
        }

        binding.btnAddKanbanTask.setOnClickListener {
            CreateTaskBottomSheet().show(parentFragmentManager, "CreateTaskBottomSheet")
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.tasks.collect { tasks ->
                    todoAdapter.submitList(tasks.filter { it.status == TaskStatus.TODO })
                    inProgressAdapter.submitList(tasks.filter { it.status == TaskStatus.IN_PROGRESS })
                    completedAdapter.submitList(tasks.filter { it.status == TaskStatus.COMPLETED })
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
