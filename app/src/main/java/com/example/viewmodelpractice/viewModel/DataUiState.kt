package com.example.viewmodelpractice.viewModel

val MAX_SCORE_INCREASE = 20
data class DataUiState(
    var currentWord : Int = 1,
    var guessRes : Boolean = true,
    var score : Int = 0,
    var playsCount:Int = 0,
    var rightWords : Int = 0,
    var wrongWords : Int = 0
)