package com.example.proyectomudanzas.mainModule


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectomudanzas.databinding.ActivityMenuBinding
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.mainModule.adapter.ContenedorAdapter
import com.example.proyectomudanzas.mainModule.adapter.OnClickListener

class MenuActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var contenedorAdapter: ContenedorAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var contenedor1 = Contenedor(
            id = 1,
            ubicacion = "Madrid",
            referencia = "5FGH",
            fecha_alta = "10/10/1010"
        )

        var contenedor2 = Contenedor(
            id = 2,
            ubicacion = "Madrid",
            referencia = "5FGH",
            fecha_alta = "10/10/1010"
        )

        var contenedor3 = Contenedor(
            id = 3,
            ubicacion = "Madrid",
            referencia = "5FGH",
            fecha_alta = "10/10/1010"
        )

        setupRecyclerView()
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

    }
}