package com.example.conexionbasedatos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.conexionbasedatos.screens.MenuInicial
import com.example.conexionbasedatos.screens.GuardarFilm
import com.example.conexionbasedatos.screens.ModificarFilm
import com.example.conexionbasedatos.screens.BorrarFilm
import com.example.conexionbasedatos.screens.ConsultarFilm
import com.example.conexionbasedatos.screens.InformeFilm




@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.MenuInicial.ruta)

    {
        composable(AppScreens.MenuInicial.ruta) {MenuInicial(navigationController) }
        composable(AppScreens.GuardarFilm.ruta) {GuardarFilm(navigationController) }
        composable(AppScreens.ModificarFilm.ruta) {ModificarFilm(navigationController) }
        composable(AppScreens.BorrarFilm.ruta) { BorrarFilm(navigationController) }
        composable(AppScreens.ConsultarFilm.ruta) {ConsultarFilm(navigationController) }
        composable(AppScreens.InformeFilm.ruta) {InformeFilm(navigationController) }
    }
}