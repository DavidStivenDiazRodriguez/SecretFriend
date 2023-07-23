package com.example.secretfriend.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.secretfriend.ViewModelFactory
import com.example.secretfriend.databinding.FragmentAssignmentBinding

class AssignmentFragment : Fragment() {

    private var _binding: FragmentAssignmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var assignmentViewModel: AssignmentViewModel
    var usernameList: List<String> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAssignmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignmentViewModel = ViewModelProvider(requireActivity(), ViewModelFactory(requireContext()))[AssignmentViewModel::class.java]

        assignmentViewModel.getUsersByUserName()
        observerListUsers()
        eventRandom()
    }

    //selecciona un elemento de la lista username
    private fun randomUserName(): String {
        val numberRandom = (0..usernameList.size).random()
        return if (usernameList.isEmpty()) {
            ""
        } else {
            usernameList[numberRandom]
        }
    }

    //evento del boton para mostrar un username aleatorio
    private fun eventRandom() {
        binding.buttonRandomFriend.setOnClickListener {
            binding.textViewUserName.text= randomUserName()
        }
    }

    //observa el LiveData para actualizar la lista de username
    private fun observerListUsers(){
        assignmentViewModel.usernames.observe(viewLifecycleOwner){
            usernameList = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}