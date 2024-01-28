package com.dorcas.auth_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dorcas.auth_app.R
import com.dorcas.auth_app.ui.theme.Pink80
import com.dorcas.auth_app.ui.theme.Purple80
import com.dorcas.auth_app.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController,authViewModel: AuthViewModel) {
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "Welcome Back!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp)

        )
        Text(text = "Enter your username & password",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp)
        )

        OutlinedTextField(
            value = userEmail,
            onValueChange = {userInput: String-> userEmail = userInput},
            label = { Text("Email")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                focusedLabelColor = Purple80,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Email" )

            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(value = password ,
            onValueChange = {userTxt -> password= userTxt},
            label = { Text("Password")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                focusedLabelColor = Purple80,
                cursorColor = Purple80,
                focusedLeadingIconColor = Purple80
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Forgot password?",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp)
                .padding(vertical = 16.dp)
        )


        Button(onClick = {
            authViewModel.loginUser(
                email = userEmail,
                password = password
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 20.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color.Transparent)

        ) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Pink80, Purple80)),
                    shape = RoundedCornerShape(40.dp)
                ),
                contentAlignment = Alignment.Center)
            {
                Text(
                    text="Login",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Create an account",
            color = Color.Red,
            modifier= Modifier
                .clickable { navController.navigate("signup") }
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter =  painterResource(id = R.drawable.google_icon),
            contentDescription = "Clickable Google Icon",
            modifier = Modifier.size(24.dp)
        )
    }
}