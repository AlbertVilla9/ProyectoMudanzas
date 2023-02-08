package com.example.proyectomudanzas.editModule.model

import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.example.proyectomudanzas.MudanzasApplication
import com.example.proyectomudanzas.database.utils.Constants
import com.example.proyectomudanzas.entities.Imagen
import com.example.proyectomudanzas.entities.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class ItemInteractor {
    fun getItem(id: Int, callback: (MutableList<Item>) -> Unit) {
        val url = Constants.URL_GENERAL + Constants.ITEM_PATH.replace("{id}", id.toString())

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

    fun updateItem(item: Item, callback: (Item) -> Unit){
        val url = Constants.URL_GENERAL + Constants.ITEM_UPDATE_PATH.replace("{id}", item.id.toString())

        var itemUpdated: Item? = null

        val jsonParams = JSONObject()
        if (item.titulo.isNotEmpty()) {
            jsonParams.put("titulo", item.titulo)
        }
        if (item.alto.toString().isNotEmpty()) {
            jsonParams.put("alto", item.alto)
        }
        if (item.ancho.toString().isNotEmpty()) {
            jsonParams.put("ancho", item.ancho)
        }
        if (item.cantidad.toString().isNotEmpty()) {
            jsonParams.put("cantidad", item.cantidad)
        }
        if (item.precio.toString().isNotEmpty()) {
            jsonParams.put("precio", item.precio)
        }
        if (item.fecha_alta.isNotEmpty()) {
            jsonParams.put("fecha_alta", item.fecha_alta)
        }
        if (item.color.toString().isNotEmpty()) {
            jsonParams.put("color", item.color)
        }
        if (item.contenedor.toString().isNotEmpty()) {
            jsonParams.put("contenedor", item.contenedor)
        }
        if (item.material.toString().isNotEmpty()) {
            jsonParams.put("material", item.material)
        }
        if (item.estado_item.toString().isNotEmpty()) {
            jsonParams.put("estado_item", item.estado_item)
        }
        if (item.preferencias.isNotEmpty()) {
            jsonParams.put("preferencias", item.preferencias)
        }
        if (item.descripcion.isNotEmpty()) {
            jsonParams.put("descripcion", item.descripcion)
        }

        val jsonArrayRequest = JsonObjectRequest(Request.Method.PUT, url, jsonParams, { response ->

            val typeToken = object : TypeToken<Item>() {}.type
            itemUpdated = Gson().fromJson(response.toString(), typeToken)

            callback(itemUpdated!!)

            return@JsonObjectRequest
        }, {
            it.printStackTrace()
            callback(itemUpdated!!)
        })

        MudanzasApplication.mudanzasAPI.addToRequestQueue(jsonArrayRequest)
    }
}