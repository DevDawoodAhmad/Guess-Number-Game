package com.example.viewmodelpractice.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.annotations.VisibleForTesting

class DataViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataUiState())
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()
    var currentWord =  _uiState.value.currentWord
    var word by mutableStateOf("")
    fun updateWord(word: String){
        this.word = word
    }

     fun currentWord(){
        val number = (1..100).random()
                currentWord = number
        }
    init {
        currentWord()
    }
    @VisibleForTesting
    internal fun userGuess(){
        if (word.toInt() == currentWord){
         _uiState.update {
             it.copy(
                 guessRes = true,
                 score = _uiState.value.score.plus(MAX_SCORE_INCREASE),
                 rightWords = _uiState.value.rightWords+1,
                 playsCount = _uiState.value.playsCount+1
                 )
         }
           updateWord("")
           currentWord()
        }
        else{
            _uiState.update {
                it.copy(
                    guessRes = false,
                    playsCount = _uiState.value.playsCount+1,
                    wrongWords = _uiState.value.wrongWords+1
                )
            }
            updateWord("")
        }
    }
}