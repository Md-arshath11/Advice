package com.example.quote.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quote.network.RetrofitInstance
import kotlinx.coroutines.launch

class AdviceViewModel:ViewModel() {

    val advice= mutableStateOf("Fetching advice")

    fun fetchAdvice(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getadvice()

                advice.value = response.slip.advice
            }catch (e:Exception){
                advice.value="Error:${e.message}"
            }
        }
    }
    init {
        fetchAdvice()
    }
}