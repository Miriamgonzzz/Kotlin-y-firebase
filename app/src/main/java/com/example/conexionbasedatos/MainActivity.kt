package com.example.conexionbasedatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.conexionbasedatos.elements.Boton
import com.example.conexionbasedatos.navigation.AppNavigation
import com.example.conexionbasedatos.screens.GuardarFilm
import com.example.conexionbasedatos.ui.theme.ConexionBaseDatosTheme

class MainActivity : ComponentActivity() {

    override fun onBackPressed() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ConexionBaseDatosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   AppNavigation()
                }
            }
        }
    }
}

//val composableWithDisabledBackButton = "".modifier(Modifier.navigationBarBackButtonEnabled(false))

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConexionBaseDatosTheme {

    }
}