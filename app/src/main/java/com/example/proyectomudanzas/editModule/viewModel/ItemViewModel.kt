package com.example.proyectomudanzas.editModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectomudanzas.database.utils.Constants
import com.example.proyectomudanzas.editModule.model.ItemInteractor
import com.example.proyectomudanzas.entities.Item

class ItemViewModel: ViewModel() {
    private var itemSelected = MutableLiveData<Item>()
    private var interactor: ItemInteractor = ItemInteractor()
    private var result = MutableLiveData<Any>()

    fun setItemSelected(item: Item) {
        itemSelected.value = item
    }

    fun getItemSelected(): LiveData<Item> {
        return itemSelected
    }

    fun updateItem(item: Item) {
        interactor.updateItem(item) { itemUpdated ->
            result.value = itemUpdated
        }
    }

}