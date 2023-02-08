package com.example.proyectomudanzas.editModule

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.proyectomudanzas.databinding.FragmentItemBinding
import com.example.proyectomudanzas.editModule.viewModel.ItemViewModel
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.MenuActivity

class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var uitem: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

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
        itemViewModel.getItemSelected().observe(viewLifecycleOwner) {
            setUItem(it)
        }
    }
    private fun setUItem(item: Item) {
        with(binding) {
            itemTitulo.text = item.titulo.editable()
            itemAlto.text = item.alto.toString().editable()
            itemAncho.text = item.ancho.toString().editable()
            itemCantidad.text = item.cantidad.toString().editable()
            itemPrecio.text = item.precio.toString().editable()
            fechaAlta.text = item.fecha_alta.editable()
            itemColor.text = item.color.toString().editable()
            itemContenedor.text = item.contenedor.toString().editable()
            itemMaterial.text = item.material.toString().editable()
            itemEstado.text = item.estado_item.toString().editable()
            itemPreferencias.text = item.preferencias.editable()
            itemDescripcion.text = item.descripcion.editable()

        }

        binding.botonUpdate.setOnClickListener{

            uitem = item

            uitem.id = item.id
            uitem.titulo = binding.itemTitulo.text.toString()
            uitem.alto = binding.itemAlto.text.toString().toInt()
            uitem.ancho = binding.itemAncho.text.toString().toInt()
            uitem.cantidad = binding.itemCantidad.text.toString().toInt()
            uitem.precio = binding.itemPrecio.text.toString().toDouble()
            uitem.fecha_alta = binding.fechaAlta.text.toString()
            uitem.color = binding.itemColor.text.toString().toInt()
            uitem.contenedor = binding.itemContenedor.text.toString().toInt()
            uitem.material = binding.itemMaterial.text.toString().toInt()
            uitem.estado_item = binding.itemEstado.text.toString().toInt()
            uitem.preferencias = binding.itemPreferencias.text.toString()
            uitem.descripcion = binding.itemDescripcion.text.toString()

            itemViewModel.updateItem(uitem)
        }

    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)


}