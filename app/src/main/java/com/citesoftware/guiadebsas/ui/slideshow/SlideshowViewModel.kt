package com.citesoftware.guiadebsas.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Este que se yo, por ahi va data de contact y asi"
    }
    val text: LiveData<String> = _text
}