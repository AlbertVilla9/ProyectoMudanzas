package com.example.proyectomudanzas.mainModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.MainActivity
import com.example.proyectomudanzas.R
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
        setupBottomNav()

    }

    private fun setupBottomNav() {

        binding.nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    var i = Intent(this, MenuActivity::class.java)
                    startActivity(i)
                    true
                }
                R.id.logout -> {
                    var i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupViewModel() {
        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menuViewModel.getContenedores().observe(this) {
                contenedores -> contenedorAdapter.setContenedores(contenedores)
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
        var ubicacion = contenedor.ubicacion
        var referencia = contenedor.referencia
        var fecha_alta = contenedor.fecha_alta

        var i = Intent(this, ContenedorActivity::class.java)
        i.putExtra( "id", id)
        i.putExtra("ubicacion", ubicacion)
        i.putExtra("referencia", referencia)
        i.putExtra("fecha_alta", fecha_alta)
        startActivity(i)
    }
    override fun onClick(item: Item) {}
}