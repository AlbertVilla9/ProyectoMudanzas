package com.example.proyectomudanzas.entities

data class Empleado (
    var nombre: String,
    var contraseña: String,
    var admin: Boolean = false
)
