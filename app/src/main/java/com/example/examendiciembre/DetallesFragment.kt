package com.example.examendiciembre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentDetallesBinding

class DetallesFragment : Fragment() {

    private var _binding: FragmentDetallesBinding? = null
    private val binding get() = _binding!!

    private val args: DetallesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetallesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detallesTitle.text = getString(R.string.detalles_titulo, args.producto)

        binding.btnDetallesVolver.setOnClickListener {
            findNavController().popBackStack();
        }





        binding.btnDetallesContinuar.setOnClickListener {
            if(checkCamposConValor()){

                val horario = if (binding.rbtComer.isChecked)
                    getString(R.string.para_comer_horario)
                else getString(R.string.para_cenar_horario)

                val action =  DetallesFragmentDirections.actionDetallesFragmentToConfirmacionFragment(
                    producto = args.producto,
                    nombre = binding.editNombre.text.toString(),
                    cantidad = binding.editCantidad.text.toString().toInt(),
                    horario = horario
                )

                findNavController().navigate(action)
            }




        }


    }

    private fun checkCamposConValor():Boolean {
        if (binding.editNombre.text.toString().isEmpty()){
            mostrarError(getString(R.string.error_nombre_vacio))
            return false;
        }

        if(binding.editCantidad.text.toString().isEmpty()){
            mostrarError(getString(R.string.error_cantidad_vacia))
            return false
        }

        return true
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }
}