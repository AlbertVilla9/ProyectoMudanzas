package com.example.proyectomudanzas.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.model.ItemsInteractor
import com.example.proyectomudanzas.database.utils.Constants
import com.example.proyectomudanzas.entities.Imagen

class ItemsViewModel: ViewModel() {
    private var itemsList: MutableList<Item>
    private var imagenesList: MutableList<Imagen>
    private var interactor: ItemsInteractor
    private var contenedorId: Int? = 0

    init {
        itemsList = mutableListOf()
        interactor = ItemsInteractor()
        imagenesList = mutableListOf()
    }

    private val items: MutableLiveData<MutableList<Item>> by lazy {
        MutableLiveData<MutableList<Item>>().also {
            loadItems()
        }
    }

    private val showProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun getItems(): LiveData<MutableList<Item>> {
        return items
    }

    fun isShowProgress(): LiveData<Boolean> {
        return showProgress
    }

    private fun loadItems() {
        showProgress.value = Constants.SHOW

        interactor.getItems(contenedorId!!) {
            showProgress.value = Constants.HIDE

            items.value = it
            itemsList = it
            for (item in itemsList){
                interactor.getImagen(item.id){
                    imagenesList = it
                }
            }

        }
    }

    fun setContenedorId(contenedorEnCursoId: Int) {
        contenedorId = contenedorEnCursoId
    }
}