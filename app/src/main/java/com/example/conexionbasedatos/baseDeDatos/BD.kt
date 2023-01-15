package com.example.conexionbasedatos.baseDeDatos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conexionbasedatos.elements.TextoBoton
import com.example.conexionbasedatos.elements.TextoElementos
import com.example.conexionbasedatos.elements.TextoMensaje
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Collections.list
import androidx.compose.material.Card as Card

val db = FirebaseFirestore.getInstance()
val nombre_coleccion = "Film"

@Composable
fun GuardarDatos(codigo:String,nombre_film:String,director_film:String,actores_film:String,fecha_film:String,descripcion_film:String,nombre_coleccion:String) {

    var codigo = codigo
    var nombre_film = nombre_film
    var director_film = director_film
    var actores_film = actores_film
    var fecha_film = fecha_film
    var descripcion_film = descripcion_film

    val dato = hashMapOf(
        "codigo" to codigo,
        "nombre" to nombre_film,
        "director" to director_film,
        "actores" to actores_film,
        "fecha" to fecha_film,
        "descripcion" to descripcion_film,
    )

    var mensaje_confirmacion by rememberSaveable { mutableStateOf("") }

    Button(

        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {

            if (codigo.isNotEmpty() && nombre_film.isNotEmpty() && director_film.isNotEmpty() && actores_film.isNotEmpty() && fecha_film.isNotEmpty() && descripcion_film.isNotEmpty()) {
                db.collection("Film")
                    .document(codigo)
                    .set(dato)
                    .addOnSuccessListener {
                        mensaje_confirmacion = "Datos guardados correctamente"
                        codigo = ""
                        nombre_film = ""
                        director_film = ""
                        actores_film = ""
                        fecha_film = ""
                        descripcion_film = ""
                    }
                    .addOnFailureListener {
                        mensaje_confirmacion = "No se ha podido guardar"
                        codigo = ""
                        nombre_film = ""
                        director_film = ""
                        actores_film = ""
                        fecha_film = ""
                        descripcion_film = ""
                    }
            } else {
                mensaje_confirmacion = "Por favor, llene todos los campos."
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Guardar")


    }
    Spacer(modifier = Modifier.size(10.dp))

        TextoMensaje(
            texto = mensaje_confirmacion,
        )

    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun Modificar(codigo:String,nombre_film:String,director_film:String,actores_film:String,fecha_film:String,descripcion_film:String){

    var codigo = codigo
    var nombre_film = nombre_film
    var director_film = director_film
    var actores_film = actores_film
    var fecha_film = fecha_film
    var descripcion_film = descripcion_film

    val dato = hashMapOf(
        "nif" to codigo,
        "nombre" to nombre_film,
        "director" to director_film,
        "actores" to actores_film,
        "fecha" to fecha_film,
        "descripcion" to descripcion_film
    )

    var mensaje_confirmacion by remember { mutableStateOf("") }

    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {
            if (codigo.isNotBlank() && nombre_film.isNotBlank() && director_film.isNotBlank() && actores_film.isNotBlank() && fecha_film.isNotBlank() && descripcion_film.isNotBlank()) {
                db.collection(nombre_coleccion)
                    .document(codigo)
                    .set(dato)
                    .addOnSuccessListener {
                        mensaje_confirmacion = "Datos guardados correctamente"
                        codigo = ""
                        nombre_film = ""
                        director_film = ""
                        actores_film = ""
                        fecha_film = ""
                        descripcion_film = ""
                    }
                    .addOnFailureListener {
                        mensaje_confirmacion = "No se ha podido guardar"
                        codigo = ""
                        nombre_film = ""
                        director_film = ""
                        actores_film = ""
                        fecha_film = ""
                        descripcion_film = ""
                    }
            }else{
                mensaje_confirmacion = "No puedes modificar, esta en blanco"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Modificar")


    }
    Spacer(modifier = Modifier.size(5.dp))
    TextoMensaje(texto = mensaje_confirmacion)
}

@Composable
fun Borrar(codigo: String){

    var mensaje_borrado by remember { mutableStateOf("") }
    var codigo = codigo

    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {
            if (codigo.isNotBlank()) {
                db.collection(nombre_coleccion)
                    .document(codigo)
                    .delete()
                    .addOnSuccessListener {
                        mensaje_borrado = "Datos borrados correctamente"
                        codigo = ""
                    }
                    .addOnFailureListener {
                        mensaje_borrado = "No se ha podido borrar"
                        codigo = ""
                    }
            }else{
                mensaje_borrado = "Esta en blanco"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Borrar")


    }
    Spacer(modifier = Modifier.size(5.dp))
    TextoMensaje(texto = mensaje_borrado)

}


@Composable
fun Buscar(codigo_busqueda:String){
    //DECLARAMOS LA VARIABLE QUE VA A RECOGER LOS DATOS DE LA CONSULTA CON EL ESTADO REMEMBER
    var datos by remember { mutableStateOf("") }
    var nombre_film = remember { mutableStateOf("") }
    var director_film = remember { mutableStateOf("") }
    var actores_film = remember { mutableStateOf("") }
    var fecha_film = remember { mutableStateOf("") }
    var descripcion_film = remember { mutableStateOf("") }

    var codigo_busqueda = codigo_busqueda
    val field_busqueda = "codigo"
    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {


            // VACIAMOS VARIABLE AL DAR AL BOTON
            datos = ""
            nombre_film.value = ""
            director_film.value=""
            actores_film.value = ""
            fecha_film.value=""
            descripcion_film.value=""
            // HACEMOS LA CONSULTA A LA COLECCION CON GET
            db.collection(nombre_coleccion)
                .whereEqualTo(field_busqueda,codigo_busqueda)
                .get()

                //SI SE CONECTA CORRECTAMENTE
                // RECORRO TODOS LOS DATOS ENCONTRADOS EN LA COLECCIÓN Y LOS ALMACENO EN DATOS
                .addOnSuccessListener { resultado ->
                    for (encontrado in resultado) {
                        //Para crear un HashMap con todos los datos
                        datos += "${encontrado.id}: ${encontrado.data}\n"

                        //Para crear un HashMap con todos los datos
                        nombre_film.value +="Nombre: ${encontrado["nombre"].toString()}"
                        director_film.value +="Director: ${encontrado["director"].toString()}"
                        actores_film.value +="Actores: ${encontrado["actores"].toString()}"
                        fecha_film.value += "Fecha:${encontrado["fecha"].toString()}"
                        descripcion_film.value +="Descripcion ${encontrado["descripcion"].toString()}"

                    }

                    if (datos.isEmpty()) {
                        datos = "No existen datos"
                    }
                }
                //SI NO CONECTA CORRECTAMENTE
                .addOnFailureListener { resultado ->
                    datos = "La conexión a FireStore no se ha podido completar"
                }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Cargar Datos")
    }

    Spacer(modifier = Modifier.size(10.dp))
    Column(
        //shape = RoundedCornerShape(20.dp),
        // backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color(0xFFE20202),
                RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF1B0303)),
                RoundedCornerShape(20.dp)
            ),
    ) {
        // PINTAMOS EL RESULTADO DE LA CONSULTA A LA BASE DE DATOS
        //Text (text = datos)
        TextoElementos(texto =  nombre_film.value)
        TextoElementos(texto =  director_film.value)
        TextoElementos(texto =  actores_film.value)
        TextoElementos(texto =  fecha_film.value)
        TextoElementos(texto = descripcion_film.value)
    }
}

@Composable
fun Informe() {

    var datos by remember { mutableStateOf("") }

    var code by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var actores by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {

            datos = ""
            code = ""
            nombre=""
            director=""
            actores=""
            fecha=""
            descripcion=""

            db.collection(nombre_coleccion)
                .get()
                  .addOnSuccessListener { resultado ->
                    for (encontrado in resultado) {

                        datos += "Código: ${encontrado.getString("codigo")?: "No disponible"}\n"
                        datos += "Nombre ${encontrado.getString("nombre") ?: "No disponible"}\n"
                        datos += "Director: ${encontrado.getString("director")?: "No disponible"}\n"
                        datos += "Actores: ${encontrado.getString("actores")?: "No disponible"}\n"
                        datos += "Fecha: ${encontrado.getString("fecha")?: "No disponible"}\n"
                        datos += "Descripción: ${encontrado.getString("descripcion")?: "No disponible"}\n\n"

                    }

                      if (datos.isEmpty()) {
                          datos = "No existen datos"
                      }
                  }.addOnFailureListener { resultado ->
                    datos = "La conexión a FireStore no se ha podido completar"
                  }

        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Cargar Datos")
    }

    Spacer(modifier = Modifier.size(10.dp))

  TextoElementos(texto = datos)

}