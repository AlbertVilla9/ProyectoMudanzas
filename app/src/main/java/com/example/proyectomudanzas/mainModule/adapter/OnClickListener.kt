package com.example.proyectomudanzas.mainModule.adapter

import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.entities.Item

interface OnClickListener {
    fun onClick(contenedor: Contenedor)
    fun onClick(item: Item)
}