package com.example.con_interface.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navigationExample() {
    val navController = rememberNavController()
    val contacts = remember { mutableListOf<Contact>() }

    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController, contacts)
        }
        composable("screen_b") {
            ScreenB(navController, contacts)
        }
    }
}