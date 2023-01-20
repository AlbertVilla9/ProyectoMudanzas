package com.example.proyectomudanzas.entities

data class Item(
    var id: Int,
    var titulo: String,
    var descripcion: String,
    var alto: Int,
    var ancho: Int,
    var fecha_alta: String,
    var preferencias: String,
    var cantiddad: Int,
    var precio: Int,
    var contenedor: Contenedor,
    var color: Int,
    var material: Int,
    var estado_item: Int,
    var empleados: Empleado
)
