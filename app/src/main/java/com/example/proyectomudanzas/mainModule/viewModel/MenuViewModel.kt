package com.example.proyectomudanzas.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectomudanzas.entities.Contenedor
import com.example.proyectomudanzas.mainModule.model.MenuInteractor
import com.example.proyectomudanzas.database.utils.Constants

class MenuViewModel: ViewModel() {
    private var contenedoresList: MutableList<Contenedor>
    private var interactor: MenuInteractor

    init {
        contenedoresList = mutableListOf()
        interactor = MenuInteractor()
    }

    private val contenedores: MutableLiveData<MutableList<Contenedor>> by lazy {
        MutableLiveData<MutableList<Contenedor>>().also {
            loadContenedores()
        }
    }

    private val showProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun getContenedores(): LiveData<MutableList<Contenedor>> {
        return contenedores
    }

    fun isShowProgress(): LiveData<Boolean> {
        return showProgress
    }

    private fun loadContenedores() {
        showProgress.value = Constants.SHOW

        interactor.getContenedores {
            showProgress.value = Constants.HIDE

            contenedores.value = it
            contenedoresList = it
        }
    }
}