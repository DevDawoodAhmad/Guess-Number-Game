package com.example.viewmodelpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.viewmodelpractice.content.AppInterface
import com.example.viewmodelpractice.navigation.DataNavHost
import com.example.viewmodelpractice.ui.theme.ViewModelPracticeTheme
import com.example.viewmodelpractice.viewModel.DataViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val dataViewModel: DataViewModel = viewModel()
                    DataNavHost(navController = navController,
                        dataViewModel = dataViewModel,
                        )
                }
            }
        }
    }
}

@Composable
fun WordsMatch(
    dataViewModel: DataViewModel,
    onButtonClick: () -> Unit
){
    Scaffold(
        topBar = { TopAppBar() }
    ){
        AppInterface(Modifier.padding(it),
            onButtonClick = onButtonClick,
            dataViewModel = dataViewModel)

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){
    TopAppBar(title = { Text(text = "Words Match",
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    )},
        colors = TopAppBarDefaults.topAppBarColors(Color.hsl(
            hue = 210f,
            saturation = 0.8f,
            lightness = 0.3f,
            alpha = 0.3f
        )),
        modifier = Modifier.padding(6.dp),
    )
}



@Preview(showBackground = true)
@Composable
fun DataNavHostCompact(
    navController : NavHostController = rememberNavController(),
    dataViewModel:DataViewModel = viewModel()
) {
    ViewModelPracticeTheme {
        DataNavHost(navController = navController, dataViewModel = dataViewModel)
    }
}
@Preview(showBackground = true, widthDp = 700)
@Composable
fun DataNavHostMedium(
    navController : NavHostController = rememberNavController(),
    dataViewModel:DataViewModel = viewModel()
){
    ViewModelPracticeTheme {
        DataNavHost(navController = navController, dataViewModel = dataViewModel)

    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun DataNavHostExpanded(
    navController : NavHostController = rememberNavController(),
    dataViewModel:DataViewModel = viewModel()
){
    ViewModelPracticeTheme {
        DataNavHost(navController = navController, dataViewModel = dataViewModel)
    }
}