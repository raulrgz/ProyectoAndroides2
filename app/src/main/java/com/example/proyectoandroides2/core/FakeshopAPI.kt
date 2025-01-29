package com.example.proyectoandroides2.core

import com.example.proyectoandroides2.model.ShopItem
import retrofit2.Response
import retrofit2.http.GET

interface FakeshopAPI {
    @GET("products")
    suspend fun getProductsInfo(): Response<List<ShopItem>>
}