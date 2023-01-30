package com.example.proyectomudanzas.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectomudanzas.entities.Item
import com.example.proyectomudanzas.mainModule.model.ItemInteractor
import com.example.proyectomudanzas.utils.Constants

class ItemViewModel: ViewModel() {
    private var itemsList: MutableList<Item>
    private var interactor: ItemInteractor

    init {
        itemsList = mutableListOf()
        interactor = ItemInteractor()
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

        interactor.getItems {
            showProgress.value = Constants.HIDE

            items.value = it
            itemsList = it
        }
    }
}