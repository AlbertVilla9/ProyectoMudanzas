package com.example.proyectomudanzas.entities

data class Item(
    var id: Int,
    var imagenes: MutableList<Imagen>,
    var titulo: String,
    var descripcion: String,
    var alto: Int,
    var ancho: Int,
    var fecha_alta: String,
    var preferencias: String,
    var cantidad: Int,
    var precio: Double,
    var contenedor: Int,
    var color: Int,
    var material: Int,
    var estado_item: Int,
    var empleados: Int
)
