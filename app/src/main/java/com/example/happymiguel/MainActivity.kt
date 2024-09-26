package com.example.happymiguel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.happymiguel.ui.theme.HappyMiguelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyMiguelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_liliana),
                        from = stringResource(R.string.from_miguel),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message:String,from:String, modifier: Modifier = Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        val image = painterResource(R.drawable.disney) // Asegúrate de que el nombre coincida
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ajustar la imagen
            modifier = Modifier
                .height(250.dp) // Puedes ajustar la altura de la imagen
                .fillMaxWidth() // Ajustar al ancho completo
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)

        )


    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)

    Box(modifier) {
        Image(painter = image, contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f)
    }
    GreetingText(message = message, from = from,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}

@Preview(showBackground = true, name = "Hola")
@Composable
fun GreetingPreview() {
    HappyMiguelTheme {
        GreetingImage(message = stringResource(R.string.happy_birthday_liliana),
            from = stringResource(
            R.string.from_miguel
        )
        )
    }
}