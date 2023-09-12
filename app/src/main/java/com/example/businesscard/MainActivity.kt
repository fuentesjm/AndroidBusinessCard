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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Share
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardCompiler(name = "Jose Manuel Fuentes", position = "Software Engineer",
                        phoneNumber = "562-513-8272", tag = "@fuentesjm", email = "fuentesjose7725@gmail.com")
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, position: String, modifier: Modifier = Modifier) {
    val icon = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .fillMaxSize()
        )
        Text(
            text = name,
            fontSize = 40.sp,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 65.dp)

        )
        Text(
            text = position,
            fontSize = 20.sp,
            color = Color.White,
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
        Row (
            modifier = Modifier
                .padding(horizontal = 100.dp)
        ) {
            Icon(
                Icons.Sharp.Call,
                contentDescription = null
            )
            Text(
                text = phoneNumber,
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(1.dp)
            )
        }
        Row (
            modifier = Modifier
                .padding(horizontal = 100.dp)
        ) {
            Icon(
                Icons.Sharp.Share,
                contentDescription = null
            )
            Text(
                text = tag,
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(1.dp)
            )
        }
        Row (
            modifier = Modifier
                .padding(horizontal = 100.dp)
        ) {
            Icon(
                Icons.Sharp.Email,
                contentDescription = null
            )
            Text(
                text = email,
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun BusinessCardCompiler(name: String, position: String, phoneNumber: String,
                  tag: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_wallpaper)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
            modifier = Modifier
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

@Preview(showBackground = false)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardCompiler(name = "Jose Fuentes", position = "Software Engineer",
                     phoneNumber = "+11 (123) 444 555", tag = "@fuentesjm", email = "johnsmith@aol.com")
    }
}