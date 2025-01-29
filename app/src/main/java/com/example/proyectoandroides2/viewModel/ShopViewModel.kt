package com.example.proyectoandroides2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroides2.core.ShopRepository
import com.example.proyectoandroides2.model.ShopItem
import kotlinx.coroutines.launch

class ShopViewModel: ViewModel() {
    private val shopRepository = ShopRepository()
    private val _shopInfo = MutableLiveData<List<ShopItem>>()
    val shopInfo: LiveData<List<ShopItem>>
        get() = _shopInfo
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun fetchShopData() {
        _loaderState.value = true
        viewModelScope.launch {
            val response = shopRepository.fetchShopInfo()
            _loaderState.value = false
            response?.let {
                _shopInfo.value = it
            } ?: run {
                Log.e("ERROR", "No se pudo obtener la informacion")
            }
        }
    }
}