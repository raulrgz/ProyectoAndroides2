package com.example.proyectoandroides2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroides2.core.SessionRepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val repository = SessionRepository()
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun loginUser(email: String, password: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val result = repository.loginUser(email, password)
            _loaderState.value = false
            result?.let { user ->
                Log.i("Session", "Se ha iniciado sesión")
            } ?: run {
                Log.e("Error", "No se pudo iniciar sesión")
            }
        }
    }
}