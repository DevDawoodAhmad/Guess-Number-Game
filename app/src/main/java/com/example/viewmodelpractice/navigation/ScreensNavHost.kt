package com.example.viewmodelpractice.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.viewmodelpractice.content.ResultScreen
import com.example.viewmodelpractice.viewModel.DataViewModel
import com.example.viewmodelpractice.WordsMatch

@Composable
fun DataNavHost(navController: NavHostController,
                dataViewModel: DataViewModel
){
    val dataUiState = dataViewModel.uiState

    NavHost(navController = navController,
        startDestination = FirstScreen){
       composable<FirstScreen> {
           WordsMatch(dataViewModel = dataViewModel){
               navController.navigate(Screens(
                   score = dataUiState.value.score,
                   plays = dataUiState.value.playsCount,
                   wrong = dataUiState.value.wrongWords,
                   right = dataUiState.value.rightWords
               ))
           }
       }
        composable<Screens> {
            val obj:Screens = it.toRoute()
            ResultScreen(
                Scores = obj.score,
                plays = obj.plays,
                wrong = obj.wrong,
                right = obj.right){
                navController.navigate(FirstScreen)
            }

        }
    }
}