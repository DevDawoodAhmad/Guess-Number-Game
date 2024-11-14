package com.example.viewmodelpractice.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    Scores : Int,
     plays : Int,
     wrong : Int,
     right : Int,
    onClick : () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ){
        Scaffold (
            modifier = Modifier.padding(6.dp),
            topBar = {
          TopAppBar(title = {
              Row (
                  horizontalArrangement = Arrangement.Center,
                  verticalAlignment = Alignment.CenterVertically
              ){
                  Icon(imageVector = Icons.Default.ArrowBack,
                      contentDescription = "ArrowBack",
                      modifier = Modifier.clickable { onClick() })
                  Spacer(modifier = Modifier.width(28.dp))
              Text(text = "Results",
              style = TextStyle(
                  fontSize = 28.sp,
                  fontFamily = FontFamily.Cursive
              ))}
          },
              colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
          )
        }){
           ResultContent(
               modifier = Modifier.padding(it),
               Scores = Scores,
               plays = plays,
               wrong = wrong,
               right = right )
        }
    }
}

@Composable
fun ResultContent(
    modifier: Modifier,
    Scores : Int,
    plays : Int,
    wrong : Int,
    right : Int
){
    Column (modifier = modifier){

        Text(text = "Words Match Result",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp,
                    vertical = 6.dp
                )
                .clip(shape = MaterialTheme.shapes.large)
                .align(Alignment.CenterHorizontally)
                .background(MaterialTheme.colorScheme.secondary),
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center)
        Card (
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Scores:" + Scores,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "Plays:" + plays,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "Wrong:" + wrong,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "Right:" + right,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}