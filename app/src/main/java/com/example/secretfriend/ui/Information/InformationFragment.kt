package com.example.secretfriend.ui.Information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.secretfriend.Username
import com.example.secretfriend.ViewModelFactory
import com.example.secretfriend.databinding.FragmentInformationBinding

class InformationFragment : Fragment()  {

    private var _binding: FragmentInformationBinding? = null

    private val binding get() = _binding!!
    private lateinit var informationViewModel: InformationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        informationViewModel = ViewModelProvider(requireActivity(), ViewModelFactory(requireContext()))[InformationViewModel::class.java]
        if (Username.id != "") {
            informationViewModel.getGiftByUserName(Username.id)
        }
        selectInformationUser()
    }

    //muestra la informacion del amigo secreto
    private fun selectInformationUser(){
        informationViewModel.gifts.observe(viewLifecycleOwner){
            if (it.gifts.isEmpty()){
                binding.textViewAliasUser.text = "Aún no se ha seleccionado un amigo secreto"
                binding.textViewOptionGift.text = ""
                binding.textViewPriceGift.text = ""
            } else {
                binding.textViewAliasUser.text = it.username
                binding.textViewOptionGift.text = it.gifts[0].description
                binding.textViewPriceGift.text = "$" + it.gifts[0].price.toString()
                if (it.gifts.size > 1) {
                    binding.textViewOptionGiftTwo.visibility = View.VISIBLE
                    binding.textViewOptionGiftTwo.text = it.gifts[1].description
                    binding.textViewPriceGiftTwo.visibility = View.VISIBLE
                    binding.textViewPriceGiftTwo.text = "$" + it.gifts[1].price.toString()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}