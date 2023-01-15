package com.example.conexionbasedatos.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.conexionbasedatos.MainActivity
import com.example.conexionbasedatos.R
import com.example.conexionbasedatos.baseDeDatos.GuardarDatos
import com.example.conexionbasedatos.cabezera.Cabezera
import com.example.conexionbasedatos.elements.TextoFild

@Composable
fun GuardarFilm(navController: NavHostController) {

    val codigo = remember  { mutableStateOf("") }
   val nombre_film = remember  { mutableStateOf("") }
   val director_film = remember { mutableStateOf("") }
   val actores_film = remember { mutableStateOf("") }
   val fecha_film = remember  { mutableStateOf("") }
   val descripcion_film = remember  { mutableStateOf("") }

    Cabezera(navController, image =R.drawable.guardar)

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

   TextoFild(parametro = codigo, texto = "Introduce el Codigo")

   Spacer(modifier = Modifier.size(10.dp))

   TextoFild(parametro = nombre_film, texto = "Introduce el nombre")

   Spacer(modifier = Modifier.size(10.dp))

   TextoFild(parametro = director_film, texto = "Indroduce el direcctor")

   Spacer(modifier = Modifier.size(10.dp))

   TextoFild(parametro =  actores_film , texto = "Introduce a los actores")

   Spacer(modifier = Modifier.size(10.dp))

   TextoFild(parametro = fecha_film, texto = "Introduce la fecha")

   Spacer(modifier = Modifier.size(10.dp))

   TextoFild(parametro = descripcion_film, texto = "Introduce la descripcion")

   Spacer(modifier = Modifier.size(10.dp))

GuardarDatos(
    codigo = codigo.value,
    nombre_film = nombre_film.value,
    director_film = director_film.value,
    actores_film = actores_film.value,
    fecha_film = fecha_film.value,
    descripcion_film = descripcion_film.value,
    nombre_coleccion = descripcion_film.value
)
}
}