package com.mank.mywordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mank.mywordle.ui.theme.darkGrey
import kotlinx.coroutines.newFixedThreadPoolContext
import java.util.stream.IntStream.range

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Black, modifier = Modifier.fillMaxSize()) {
                Column {
                    Title()
                    var enteredWords = remember {
                        mutableListOf<String>("EMPTY", "CLEAR", "     ", "     ", "     ", "     ")
                    }
                    Word(givenWord = enteredWords[0])
                    Word(givenWord = enteredWords[1])
                    Word(givenWord = enteredWords[2])
                    Word(givenWord = enteredWords[3])
                    Word(givenWord = enteredWords[4])
                    Word(givenWord = enteredWords[5])
                    Button(onClick = {enteredWords[0] = "MANKY"}) {
                        //try making JUST ONE composable
                    }
                }
            }
        }
    }
}

val poppins = FontFamily(
    Font(
        R.font.poppins_regular
    )
)

val ubermove = FontFamily(
    Font(
        R.font.ubermove_medium
    )
)

@Composable
fun Title() {
    Row(
        verticalAlignment = Top,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .padding(bottom = 15.dp)
    )
    {
        Text(
            text = " W | * | R | D | L | E ",
            color = White, fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.border(color = White, width = 1.dp),
        )
    }
}

@Composable
fun Letter(givenLetter: Char) {
    Row(
        modifier = Modifier
            .size(50.dp, 50.dp)
            .background(color = Black)
            .border(shape = RectangleShape, color = darkGrey, width = 1.dp)
    )
    {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp),
            fontFamily = ubermove,
            text = "$givenLetter",
            color = White,
            softWrap = true,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun Word(givenWord: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(shape = RectangleShape, color = Black, width = 2.dp)
            .fillMaxWidth()
            .padding(top = 3.dp, bottom = 5.dp, start = 0.dp, end = 0.dp)
    )
    {
        for (i in 0..4) {
            Letter(givenWord[i])
            Spacer(modifier = Modifier.padding(3.dp))
        }
    }
}