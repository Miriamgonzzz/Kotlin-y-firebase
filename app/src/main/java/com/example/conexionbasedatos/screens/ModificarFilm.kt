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
import com.example.conexionbasedatos.baseDeDatos.Modificar
import com.example.conexionbasedatos.cabezera.Cabezera
import com.example.conexionbasedatos.elements.Texto
import com.example.conexionbasedatos.elements.TextoFild
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ModificarFilm(navController: NavHostController) {

    val codigo = remember  { mutableStateOf("") }
    val nombre_film = remember  { mutableStateOf("") }
    val director_film = remember { mutableStateOf("") }
    val actores_film = remember { mutableStateOf("") }
    val fecha_film = remember  { mutableStateOf("") }
    val descripcion_film = remember  { mutableStateOf("") }

    Cabezera(navController, image = R.drawable.modificar)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp)
                .padding(start = 10.dp)
                .padding(end = 10.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Spacer(modifier = Modifier.size(10.dp))

            Texto(
                texto = "Modificar Pelicula"
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextoFild(parametro = codigo, texto = "Introduce el codigo")

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(parametro = nombre_film, texto = "Introduce el nombre")

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(parametro = director_film, texto = "Introduce el director")

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(parametro = actores_film, texto = "Introduce los actores")

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(parametro = fecha_film, texto = "Introduce la fecha")

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(parametro = descripcion_film, texto = "Introduce la descripcion")

            Spacer(modifier = Modifier.size(10.dp))

            Modificar(
                codigo = codigo.value,
                nombre_film = nombre_film.value,
                director_film = director_film.value,
                actores_film = actores_film.value,
                fecha_film = fecha_film.value,
                descripcion_film = descripcion_film.value
            )
        }
}