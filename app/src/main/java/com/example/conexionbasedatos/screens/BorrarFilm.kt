package com.example.conexionbasedatos.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.conexionbasedatos.R
import com.example.conexionbasedatos.baseDeDatos.Borrar
import com.example.conexionbasedatos.cabezera.Cabezera
import com.example.conexionbasedatos.elements.Texto
import com.example.conexionbasedatos.elements.TextoFild
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun BorrarFilm(navController: NavHostController) {

    var codigo = remember { mutableStateOf("") }

    Cabezera(navController, image = R.drawable.borrar)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 185.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState()),

    ) {
        Spacer(modifier = Modifier.size(10.dp))

        Texto(
            texto = "Eliminar pelicula"
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(parametro = codigo, texto = "Introduce el codigo a borrar")

        Spacer(modifier = Modifier.size(5.dp))

        Borrar(codigo = codigo.value)
    }
}