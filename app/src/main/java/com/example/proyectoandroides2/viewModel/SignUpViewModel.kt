package com.example.proyectoandroides2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroides2.core.SessionRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    private val repository = SessionRepository()
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState
    private val _userInfo = MutableLiveData<FirebaseUser>()
    val userInfo: LiveData<FirebaseUser>
        get() = _userInfo

    /*
    fun registerUser(email: String, password: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val response = userRepository.fetchUserInfo(email, password)
            _loaderState.value = false
            response?.let { user ->
                _userInfo.value = user
            } ?: run {
                Log.e("Error", "No se pudo crear la informacion")
            }
        }
    }*/

    fun createUser(email: String, password: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val result = repository.registerUser(email, password)
            _loaderState.value = false
            result?.let {
                _userInfo.value = it
                Log.i("Session", "Se ha creado el usuario")
            } ?: run {
                Log.e("Error", "No se pudo crear el usuario")
            }
        }
    }
}