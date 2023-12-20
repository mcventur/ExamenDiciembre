package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentConfirmacionBinding

class ConfirmacionFragment : Fragment() {
    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!
    private val args:ConfirmacionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfirmacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvConfirmacionNombre.text = getString(R.string.nombre_confirmacion, args.nombre)
        binding.tvConfirmacionHorario.text = getString(R.string.horario_confirmacion, args.horario)
        binding.tvConfirmacionPedido.text = getString(R.string.pedido_confirmacion, args.cantidad, args.producto)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}