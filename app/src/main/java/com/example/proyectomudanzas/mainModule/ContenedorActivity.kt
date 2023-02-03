package com.example.proyectomudanzas.mainModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.editModule.ItemFragment
import com.example.proyectomudanzas.MainActivity
import com.example.proyectomudanzas.R
import com.example.proyectomudanzas.databinding.ActivityContenedorBinding
import com.example.proyectomudanzas.editModule.viewModel.ItemViewModel
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.adapter.ItemsAdapter
import com.example.proyectomudanzas.mainModule.adapter.OnClickListener
import com.example.proyectomudanzas.mainModule.viewModel.ItemsViewModel

class ContenedorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityContenedorBinding
    private lateinit var itemAdapter: ItemsAdapter
    private lateinit var mGridLayout: GridLayoutManager
    private lateinit var itemsViewModel: ItemsViewModel
    private lateinit var FragmentManager: FragmentManager
    private lateinit var ItemViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getIntExtra("id", 1)
        var ubicacion = intent.getStringExtra("ubicacion")
        var referencia = intent.getStringExtra("referencia")
        var fecha_alta = intent.getStringExtra("fecha_alta")

        binding.idContenedor.text = id.toString()
        binding.ubicacion.text = ubicacion
        binding.referencia.text = referencia
        binding.fechaAlta.text = fecha_alta

        setupRecyclerView()
        setupViewModel(id)
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

    private fun setupViewModel(contenedorId: Int) {
        itemsViewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        itemsViewModel.setContenedorId(contenedorId)
        itemsViewModel.getItems().observe(this) {
                items -> itemAdapter.setItems(items)
        }

    }

    private fun launchItemFragment(item: Item = Item()) {
        ItemViewModel.setItemSelected(item)

        val fragment = ItemFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.contenedorActivity, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun setupRecyclerView() {

        itemAdapter = ItemsAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)

        binding.recyclerItem.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = itemAdapter
        }
    }



    // Al hacer click en un item del recyclerView
    override fun onClick(item: Item) {
        launchItemFragment()
    }
    override fun onClick(contenedor: Contenedor) {}
}