package com.example.proyectomudanzas.entities

import android.media.Image

data class Item(
    var nombre: String,
    var alto: Int,
    var ancho: Int,
    var descripcion: String,
    var imagen: Image
)
