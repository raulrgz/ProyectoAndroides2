package com.example.proyectoandroides2.model

data class ShopItem(
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double
)