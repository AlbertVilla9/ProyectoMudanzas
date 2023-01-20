package com.example.proyectomudanzas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.databinding.ActivityContenedorBinding
import com.example.proyectomudanzas.databinding.ActivityMenuBinding
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.adapter.ContenedorAdapter
import com.example.proyectomudanzas.mainModule.adapter.ItemAdapter
import com.example.proyectomudanzas.mainModule.adapter.OnClickListener
import com.example.proyectomudanzas.mainModule.viewModel.MenuViewModel

class ContenedorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityContenedorBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getIntExtra("id", 1)

        binding.numcontenedor.text = id.toString()
    }

    private fun setupRecyclerView() {
        itemAdapter = ItemAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)

        binding.recyclerItem.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = itemAdapter
        }
    }



    // Al hacer click en un item del recyclerView
    override fun onClick(item: Item) {
        
    }
    override fun onClick(contenedor: Contenedor) {}
}