package com.example.conexionbasedatos.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.conexionbasedatos.R
import com.example.conexionbasedatos.baseDeDatos.Buscar
import com.example.conexionbasedatos.baseDeDatos.db
import com.example.conexionbasedatos.baseDeDatos.nombre_coleccion
import com.example.conexionbasedatos.cabezera.Cabezera
import com.example.conexionbasedatos.elements.Texto
import com.example.conexionbasedatos.elements.TextoFild
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ConsultarFilm(navController: NavHostController) {

    Cabezera(navController, image = R.drawable.busqueda)
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 185.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState())

    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Texto(
            texto = "Búsqueda de peliculas "
        )

        Spacer(modifier = Modifier.size(20.dp))

        var codigo_busqueda = remember { mutableStateOf("") }

        TextoFild(parametro = codigo_busqueda, texto = "Introduce el codigo a consultar")

        Spacer(modifier = Modifier.size(5.dp))

        Buscar(codigo_busqueda = codigo_busqueda.value)

    }

}