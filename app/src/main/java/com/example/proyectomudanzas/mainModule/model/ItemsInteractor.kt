package com.example.proyectomudanzas.mainModule.model

import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.proyectomudanzas.MudanzasApplication
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.database.utils.Constants
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
}