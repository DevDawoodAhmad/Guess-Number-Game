package com.example.viewmodelpractice.content

import android.text.style.ClickableSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodelpractice.R
import com.example.viewmodelpractice.viewModel.DataViewModel

@Composable
fun AppInterface(modifier: Modifier = Modifier,
                 dataViewModel: DataViewModel,
                 onButtonClick: () -> Unit){
     val dataUiState by dataViewModel.uiState.collectAsState()
     var word = dataViewModel.word
     val keyBoardController  = LocalSoftwareKeyboardController.current
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(text = "Score:"+ dataUiState.score,
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.medium)
                        .align(alignment = Alignment.End)
                        .background(MaterialTheme.colorScheme.surfaceTint)
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary)

                Text(text = stringResource(id = R.string.words_Guess),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )

                DataField(
                    value = word,
                    onValueChange = {
                        if(it.all {char->
                            char.isDigit()|| char.isWhitespace()
                        }){
                       word = dataViewModel.updateWord(it).toString()
                    }},
                    label = "Enter Text",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                        ),
                    rightOrWrong = !(dataUiState.guessRes),
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                    onAction = KeyboardActions{
                        if (keyBoardController != null) {
                            keyBoardController.hide()
                        }
                    }
                )

                TextButton(text = "Check",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                    dataViewModel.userGuess()
                }
                Text(text = dataViewModel.currentWord.toString())
                if (dataUiState.guessRes){
                Text(
                    text = "You are Right",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )) }
                else{
                    Text(
                        text = "Guess is Wrogn",
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        ))

                }
            }

        }
        TextButton(text = "Check Result",
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp)) {
            onButtonClick()
        }
    }
}
@Composable
fun TextButton(
    modifier : Modifier = Modifier,
    text : String,
    onButtonClick : () -> Unit
){
    Button(onClick =onButtonClick,
        modifier = modifier,
        ) {
        Text(text = text)

    }
}
@Composable
fun DataField(value:String,
              onValueChange:(String) -> Unit,
              modifier: Modifier = Modifier,
              label : String,
              singleLine:Int = 1,
              rightOrWrong : Boolean = false,
              keyboardType: KeyboardType,
              imeAction: ImeAction,
              onAction: KeyboardActions = KeyboardActions.Default
){
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = label)},
        maxLines = singleLine,
        isError = rightOrWrong,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction
        )
}

@Preview(showBackground = true)
@Composable
fun AppInterfacePreview(){
//    AppInterface()
}