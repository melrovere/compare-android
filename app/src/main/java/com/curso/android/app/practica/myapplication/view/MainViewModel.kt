package com.curso.android.app.practica.myapplication.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.myapplication.model.Comparison
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()  {

    val comparison: LiveData<Comparison> get() = _comparison
    private var _comparison = MutableLiveData<Comparison>(Comparison(false, ""))

    fun compare(text1: String, text2: String) {
        if (text1 == text2) {
            val bool = true
            val desc = "Los textos son iguales."
            updateComparison(bool, desc)
        } else {
            val bool = false
            val desc = "Los textos son distintos."
            updateComparison(bool, desc)
        }
    }

    private fun updateComparison(boolean: Boolean, description: String) {
        viewModelScope.launch {
            _comparison.value = Comparison(boolean, description)
        }
    }
}