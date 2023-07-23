package com.example.secretfriend.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.secretfriend.ViewModelFactory
import com.example.secretfriend.Retrofit.Gifts
import com.example.secretfriend.Retrofit.User
import com.example.secretfriend.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null


    private val binding get() = _binding!!
    private lateinit var registerViewModel: RegisterViewModel
    private var userName: String= ""
    private var userLastName: String= ""
    private var userAlias: String= ""
    private var giftName: String= ""
    private var giftPrice: Int?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerViewModel = ViewModelProvider(requireActivity(), ViewModelFactory(requireContext()))[RegisterViewModel::class.java]
        events()
    }

    //Obtiene los datos de los editText
    private fun getDataRegistered(){
        userName = binding.editTextUsername.text.toString()
        userLastName= binding.editTextUserLastName.text.toString()
        userAlias= binding.editTextUserAlias.text.toString()
        giftName = binding.editTextGiftName.text.toString()

        giftPrice = if (binding.editTextGiftPrice.text.toString().isBlank()) {
            null
        } else {
            binding.editTextGiftPrice.text.toString().toInt()
        }
    }

    //Evento del boton de registro
    private fun events(){
        binding.buttonRegister.setOnClickListener {
            getDataRegistered()
            registerViewModel.postRegisterUser(User(userAlias, userName, userLastName, listOf(Gifts(giftName, giftPrice ?: 0))))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}