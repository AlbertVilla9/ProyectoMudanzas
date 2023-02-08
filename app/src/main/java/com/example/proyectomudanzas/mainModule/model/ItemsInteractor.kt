package com.example.proyectomudanzas.mainModule.model

import android.media.Image
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.proyectomudanzas.MudanzasApplication
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.database.utils.Constants
import com.example.proyectomudanzas.entities.Imagen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemsInteractor {
    fun getItems(id: Int, callback: (MutableList<Item>) -> Unit) {
        val url = Constants.URL_GENERAL + Constants.ITEMS_CONTENEDOR_PATH.replace("{id}", id.toString())

        var itemList = mutableListOf<Item>()

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->


            val typeToken = object : TypeToken<MutableList<Item>>() {}.type
            itemList = Gson().fromJson(response.toString(), typeToken)

            callback(itemList)

            return@JsonArrayRequest
        }, {
            it.printStackTrace()
            callback(itemList)
        })

        MudanzasApplication.mudanzasAPI.addToRequestQueue(jsonArrayRequest)
    }

    fun getImagen(id: Int, callback: (MutableList<Imagen>) -> Unit){
        val url = Constants.URL_GENERAL + Constants.ITEMS_IMGEN_PATH.replace("{id}", id.toString())

        var imagen = mutableListOf<Imagen>()

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, { response ->


            val typeToken = object : TypeToken<MutableList<Imagen>>() {}.type
            imagen = Gson().fromJson(response.toString(), typeToken)

            callback(imagen)

            return@JsonArrayRequest
        }, {
            it.printStackTrace()
            callback(imagen)
        })

        MudanzasApplication.mudanzasAPI.addToRequestQueue(jsonArrayRequest)
    }
}