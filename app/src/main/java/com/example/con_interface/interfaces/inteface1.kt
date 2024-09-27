package com.example.con_interface.interfaces

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

data class Contact(val firstName: String, val lastName: String, val phone: String, val hobbies: String)

@Composable
fun ScreenA(navController: NavController, contacts: MutableList<Contact>) {
    val backgroundColor = Color.Gray
    val textColor = Color.White
    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var hobbies by remember { mutableStateOf(TextFieldValue("")) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                if (firstName.text.isEmpty()) {
                    Text(text = "Nombre", color = textColor)
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                if (lastName.text.isEmpty()) {
                    Text(text = "Apellido", color = textColor)
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                if (phone.text.isEmpty()) {
                    Text(text = "Telefono", color = textColor)
                }
                innerTextField()
            }
        )
        BasicTextField(
            value = hobbies,
            onValueChange = { hobbies = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                if (hobbies.text.isEmpty()) {
                    Text(text = "Hobby", color = textColor)
                }
                innerTextField()
            }
        )
        Button(onClick = {
            if (firstName.text.isEmpty() || lastName.text.isEmpty() || phone.text.isEmpty() || hobbies.text.isEmpty()) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Todos los campos deben estar llenos")
                }
            } else {
                contacts.add(Contact(firstName.text, lastName.text, phone.text, hobbies.text))
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Registro exitoso")
                }
            }
        }) {
            Text(text = "Registrar Contacto")
        }
        Button(onClick = {
            if (contacts.isEmpty()) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("No hay contactos para mostrar")
                }
            } else {
                navController.navigate("screen_b")
            }
        }) {
            Text(text = "Ver lista de contactos")
        }
        SnackbarHost(hostState = snackbarHostState)
    }
}