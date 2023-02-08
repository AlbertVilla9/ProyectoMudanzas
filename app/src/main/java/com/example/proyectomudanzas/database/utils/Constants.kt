package com.example.proyectomudanzas.database.utils

object Constants {
    const val URL_GENERAL = "http://apicei14.ieslasenia.org"
    const val CONTENEDORES_PATH = "/contenedores"
    const val ITEM_PATH = "/item?pk={id}"
    const val ITEMS_CONTENEDOR_PATH = "/contenedor/items?pk={id}"
    const val ITEMS_IMGEN_PATH = "/imagen?pk={id}"
    const val ITEM_UPDATE_PATH = "/item?pk={id}"

   // const val STATUS_PROPERTY = "status"
   // const val STORES_PROPERTY = "stores"

    const val SUCCESS = 1
    const val ERROR = 2

    const val SHOW = true
    const val HIDE = false
}