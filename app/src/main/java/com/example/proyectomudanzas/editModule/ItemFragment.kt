package com.example.proyectomudanzas.editModule

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.proyectomudanzas.R
import com.example.proyectomudanzas.databinding.FragmentItemBinding
import com.example.proyectomudanzas.editModule.viewModel.ItemViewModel
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.viewModel.ItemsViewModel

class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    private lateinit var ItemViewModel: ItemViewModel
    private lateinit var item: Item

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //MVVM
        setupViewModel()
    }

    private fun setupViewModel() {
        ItemViewModel.getItemSelected().observe(viewLifecycleOwner) {
            item = it

        }
    }
    private fun setUItem(item: Item) {
        with(binding) {
            itemTitulo.text = item.titulo.editable()
            itemAlto.text = item.alto.editable()
            itemAncho.text = item.ancho.editable()
            itemCantidad.text = item.cantidad.editable()
        }
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)
    private fun Int.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

}