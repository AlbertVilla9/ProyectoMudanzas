package com.example.proyectomudanzas

data class Usuario(
    var nombre: String,
    var contraseña: String,
    var admin: Boolean = false
)
