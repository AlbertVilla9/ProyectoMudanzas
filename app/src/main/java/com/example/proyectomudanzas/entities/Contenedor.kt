package com.example.proyectomudanzas.entities

data class Contenedor(
    var id: Int,
    var dueño: String,
    var items: List<Item>
)
