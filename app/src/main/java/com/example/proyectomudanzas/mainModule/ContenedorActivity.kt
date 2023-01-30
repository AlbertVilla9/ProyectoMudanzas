package com.example.proyectomudanzas.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.databinding.ActivityContenedorBinding
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.adapter.ItemAdapter
import com.example.proyectomudanzas.mainModule.adapter.OnClickListener
import com.example.proyectomudanzas.mainModule.viewModel.ItemViewModel
import com.example.proyectomudanzas.mainModule.viewModel.MenuViewModel

class ContenedorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityContenedorBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var mGridLayout: GridLayoutManager
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getIntExtra("id", 1)

        binding.numcontenedor.text = id.toString()

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        itemViewModel.getItems().observe(this) {
                items -> itemAdapter.setItems(items)
        }

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