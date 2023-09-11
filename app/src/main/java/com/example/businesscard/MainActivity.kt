package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    GreetingImage(name = "Jose Manuel Fuentes", position = "Software Engineer",
                        phoneNumber = "562-513-8272", tag = "@fuentesjm", email = "fuentesjose7725@gmail.com")
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, position: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 40.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = position,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun BusinessContacts(phoneNumber: String, tag: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        Text(
            text = phoneNumber,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = tag,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = email,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(name: String, position: String, phoneNumber: String,
                  tag: String, email: String, modifier: Modifier = Modifier) {
    val icon = painterResource(R.drawable.android_logo)
    Box {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .align(alignment = Alignment.Center)
                .fillMaxSize()
        )
        GreetingText(
            name = name,
            position = position,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
        BusinessContacts(
            phoneNumber = phoneNumber,
            tag = tag,
            email = email,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        GreetingImage(name = "Jose Manuel Fuentes", position = "Software Engineer",
                     phoneNumber = "+1 (562) 513 8272", tag = "@fuentesjm", email = "fuentesjose7725@gmail.com")
    }
}