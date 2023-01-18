package com.example.proyectomudanzas.mainModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomudanzas.R
import com.example.proyectomudanzas.databinding.ItemContenedorBinding
import com.example.proyectomudanzas.entities.Contenedor

class ContenedorAdapter(
    private var contenedores: MutableList<Contenedor>,
    private var listener: OnClickListener
    ):
    RecyclerView.Adapter<ContenedorAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contenedor, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contenedor = contenedores.get(position)

        with(holder) {
            setListener(contenedor)

            binding.idContenedor.text = contenedor.id.toString()
            binding.ubicacion.text = contenedor.ubicacion
            binding.referencia.text = contenedor.referencia
            binding.fechaAlta.text = contenedor.fecha_alta
        }
    }

    override fun getItemCount(): Int = contenedores.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemContenedorBinding.bind(view)

        fun setListener(contenedor: Contenedor) {
            binding.root.setOnClickListener {
                listener.onClick(contenedor)
            }
        }
    }
}