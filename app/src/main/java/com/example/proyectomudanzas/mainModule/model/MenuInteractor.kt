package com.example.proyectomudanzas.mainModule.model

import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.proyectomudanzas.MudanzasApplication
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.database.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MenuInteractor {

    fun getContenedores(callback: (MutableList<Contenedor>) -> Unit) {
        val url = Constants.URL_GENERAL + Constants.CONTENEDORES_PATH

        var contenedorlist = mutableListOf<Contenedor>()

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->


            val typeToken = object : TypeToken<MutableList<Contenedor>>() {}.type
            contenedorlist = Gson().fromJson(response.toString(), typeToken)

            callback(contenedorlist)

            return@JsonArrayRequest
        }, {
            it.printStackTrace()
            callback(contenedorlist)
        })

        MudanzasApplication.mudanzasAPI.addToRequestQueue(jsonArrayRequest)
    }
}