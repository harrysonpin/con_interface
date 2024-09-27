package com.example.con_interface.interfaces

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(navController: NavController, contacts: List<Contact>) {
    val backgroundColor = Color.Gray
    val textColor = Color.White
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de contactos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = textColor
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(backgroundColor),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                contacts.forEach { contact ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = "Nombre: ${contact.firstName}", fontSize = 18.sp, color = textColor)
                            Text(text = "Apellido: ${contact.lastName}", fontSize = 18.sp, color = textColor)
                            Text(text = "Telefono : ${contact.phone}", fontSize = 18.sp, color = textColor)
                            Text(text = "Hobby : ${contact.hobbies}", fontSize = 18.sp, color = textColor)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Ir al inicio")
                }
            }
        }
    )
}