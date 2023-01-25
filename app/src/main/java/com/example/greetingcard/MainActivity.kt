package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingCardWithImage(
                        "Rakshitha M L",
                        "Shivaraj Avate"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingCardWithText(to: String, from: String) {
    Column() {
        Text(
            text = "Many happy returns of the day $to!",
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Blue,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(24.dp)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Text(
            text = "Thanks & Regards",
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Blue,
            modifier = Modifier
                .padding(start = 8.dp, top = 24.dp, end = 24.dp, bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Blue,
            modifier = Modifier
                .padding(end = 24.dp, bottom = 8.dp)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingCardWithImage(to: String, from: String) {
    val image = painterResource(id = R.drawable.birthday)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        GreetingCardWithText(to, from)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingCardWithImagePreview() {
    GreetingCardTheme {
        GreetingCardWithImage(
            "Rakshitha M L",
            "Shivaraj Avate"
        )
    }
}