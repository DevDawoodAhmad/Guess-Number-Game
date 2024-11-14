package com.example.viewmodelpractice.ui.test

import com.example.viewmodelpractice.viewModel.DataUiState
import com.example.viewmodelpractice.viewModel.DataViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ViewModelUnitTest {
    val viewModel = DataViewModel()
    @Test
    fun dataViewModel_InitialState_GuessTruePlaysAndScoresAreZero(){
        var currentUiState = viewModel.uiState.value
        assertEquals(true,currentUiState.guessRes)
        assertEquals(0,currentUiState.playsCount)
    }
    @Test
    fun dataViewModel_CorrectNumberGuess_UpdateNumberScoresAndUserGuess(){
        var currentUiState = viewModel.uiState.value
        val nowWord = viewModel.currentWord.toString()
        viewModel.updateWord(nowWord)
        viewModel.userGuess()
        currentUiState = viewModel.uiState.value
        assertEquals(1 ,currentUiState.playsCount)
        assertEquals(0,currentUiState.wrongWords)
        assertEquals(1,currentUiState.rightWords)
        assertEquals(20,currentUiState.score)
        //assertEquals(20 ,currentUiState.score)
    }

    @Test
    fun dataViewModel_IncorrectNumberGuess_UpdateNumberAndUserGuessNotScores(){
        val IncorrectWord = 101
        viewModel.updateWord(IncorrectWord.toString())
        viewModel.userGuess()
        val currentUiState: DataUiState = viewModel.uiState.value
        assertEquals(false ,currentUiState.guessRes)
        assertEquals(1,currentUiState.playsCount)
    }
}