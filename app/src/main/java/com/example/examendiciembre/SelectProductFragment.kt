package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examendiciembre.databinding.FragmentSelectProductBinding

class SelectProductFragment : Fragment() {

    private var _binding: FragmentSelectProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectProductBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivHamburguer.setOnClickListener{
            val action = SelectProductFragmentDirections
                .actionSelectProductFragmentToDetallesFragment(getString(R.string.hamburguesa))

            findNavController().navigate(action)
        }

        binding.ivPizza.setOnClickListener{

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}