package com.example.proyectoandroides2.core

import android.util.Log
import com.example.proyectoandroides2.model.ShopItem

class ShopRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(FakeshopAPI::class.java)

    suspend fun fetchShopInfo(): List<ShopItem>? {
        val response = retrofit.getProductsInfo()
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }

}