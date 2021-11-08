package com.citesoftware.guiadebsas.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Aca va la guia con las actividades"
    }
    val text: LiveData<String> = _text
}