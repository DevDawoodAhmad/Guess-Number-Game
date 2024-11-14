package com.example.viewmodelpractice.navigation

import kotlinx.serialization.Serializable

@Serializable
data class Screens(
    val score : Int,
    val  plays : Int,
    val wrong : Int,
    val right : Int
)
@Serializable
data object FirstScreen
