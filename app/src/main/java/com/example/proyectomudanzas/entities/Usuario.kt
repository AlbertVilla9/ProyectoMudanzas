package com.example.proyectomudanzas.entities

data class Usuario(
    var nombre: String,
    var contraseña: String,
    var admin: Boolean = false
)
