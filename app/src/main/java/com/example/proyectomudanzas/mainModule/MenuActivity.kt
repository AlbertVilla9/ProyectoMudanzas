package com.example.proyectomudanzas.mainModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.ContenedorActivity
import com.example.proyectomudanzas.databinding.ActivityMenuBinding
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.adapter.ContenedorAdapter
import com.example.proyectomudanzas.mainModule.adapter.OnClickListener
import com.example.proyectomudanzas.mainModule.viewModel.MenuViewModel

class MenuActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var contenedorAdapter: ContenedorAdapter
    private lateinit var mGridLayout: GridLayoutManager
    private lateinit var menuViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupRecyclerView()
        setupViewModel()

    }

    private fun setupViewModel() {
        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuViewModel.getContenedores().observe(this) {
                contendores -> contenedorAdapter.setContenedores(contendores)
        }

    }

    private fun setupRecyclerView() {
        contenedorAdapter = ContenedorAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)

        binding.recyclerContenedor.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = contenedorAdapter
        }
    }

    // Al hacer click en un contenedor del recyclerView
    override fun onClick(contenedor: Contenedor) {
        var id = contenedor.id
        var i = Intent(this, ContenedorActivity::class.java)
        i.putExtra( "id", id)
        startActivity(i)
    }
    override fun onClick(item: Item) {}
}