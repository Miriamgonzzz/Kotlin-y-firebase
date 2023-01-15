package com.example.conexionbasedatos.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Boton(navController: NavHostController,Router:String, Text:String){
    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
    onClick = {
        navController.navigate(Router)
    },

    colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent,
        contentColor = Color.White
    ),
    border = BorderStroke(2.dp, Color.Black)

    )

    {
        Text(text = Text,fontSize = 20.sp)

    }

}

@Composable
fun TextoBoton(texto:String){

    Text(text = texto, color = Color(0xFFFFFFFF),fontSize = 20.sp)

}

@Composable
fun TextoMensaje(texto:String){
    Card(
        shape = CutCornerShape( 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color=Color(0xFF5C0606),CutCornerShape( 20.dp))
            .border(
                BorderStroke(5.dp, Color(0xFF300000)),
                CutCornerShape( 20.dp)
            ),

        ) {
        Text(
            text = texto,
            modifier = Modifier.padding(top = 10.dp),
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun TextoElementos(texto:String){

    Column(
        //shape = RoundedCornerShape(20.dp),
        // backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFFBE9999), Color(0xFF1F0031))),
                RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF1B0303)),
                RoundedCornerShape(20.dp)
            ),
    ) {


        Text(text = texto,modifier=Modifier.fillMaxWidth().padding(10.dp) ,color = Color(0xFFFFFDFD), fontSize = 20.sp, textAlign = TextAlign.Center)


    }

}

@Composable
fun Texto(texto:String){
    Card(
        shape = CutCornerShape( 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color=Color(0xFF422626),CutCornerShape( 20.dp))
            .border(
                BorderStroke(5.dp, Color(0xFF300000)),
                CutCornerShape( 20.dp)
            ),

        ) {
        Text(
            text = texto,
            modifier = Modifier.padding(top = 10.dp),
            color = Color(0xFFF03C3C),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun TextoFild(parametro: MutableState<String>, texto: String){

    OutlinedTextField(
        shape = RoundedCornerShape(topStart = 30.dp),
        value = parametro.value,
        onValueChange = { parametro.value = it },
        label = { Text(texto) },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFFBE9999), Color(0xFF1F0031))),
                RoundedCornerShape(topStart = 30.dp)
            ),

        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFF1B0303),
            focusedBorderColor = Color(0xFFBC7AE6),
            focusedLabelColor = Color(0xFFFCACFF),
            unfocusedLabelColor = Color(0xFFFEFFFE),
            cursorColor = Color(0xFF6904F7)
        ),
        textStyle = TextStyle.Default.copy(fontSize = 28.sp),
    )
}

/*@Composable
fun ModificadoresBoton( shape: CutCornerShape, modifier: Modifier, color: ButtonDefaults, border: BorderStroke){
    var shape = shape
    var modifier = modifier
    var color= color
    var border = border

     shape=CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
    modifier=Modifier
        .size(220.dp, 50.dp)
        .background(
            Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
            CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
        )
    color=ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent,
        contentColor = Color.White
    )
    border=BorderStroke(2.dp, Color.Black)
}
data class BotonModifiers(val shape: Shape, val modifier: Modifier, val colors: ButtonDefaults.Colors, val border: BorderStroke)

@Composable
fun ModificadoresBoton(): BotonModifiers {
    return BotonModifiers(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        colors = ButtonDefaults.Colors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
}*/

@Composable
fun Border(){

}