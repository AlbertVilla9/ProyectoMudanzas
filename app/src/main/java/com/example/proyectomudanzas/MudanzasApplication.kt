package com.example.proyectomudanzas

import android.app.Application
import com.example.proyectomudanzas.database.MudanzasAPI

class MudanzasApplication: Application(){

    companion object {
        lateinit var mudanzasAPI: MudanzasAPI
    }

    override fun onCreate() {
        super.onCreate()

        // Volley
        mudanzasAPI = MudanzasAPI(this)
    }
}