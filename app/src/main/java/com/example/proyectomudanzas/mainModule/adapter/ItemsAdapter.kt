package com.example.proyectomudanzas.mainModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectomudanzas.R
import com.example.proyectomudanzas.databinding.ItemItemBinding
import com.example.proyectomudanzas.entities.Item

class ItemsAdapter(
    private var items: MutableList<Item>,
    private var listener: OnClickListener
):
RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)

        with(holder) {
            setListener(item)

            binding.nombremueble.text = item.titulo
            binding.alto.text = item.alto.toString()
            binding.ancho.text = item.ancho.toString()
            binding.descripcion.text = item.descripcion

            Glide.with(itemView)
                .load(item.imagenes)
                .centerCrop()
                .into(binding.imagen)

        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: MutableList<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemItemBinding.bind(view)

        fun setListener(item: Item) {
            binding.root.setOnClickListener {
                listener.onClick(item)
            }
        }
    }
}