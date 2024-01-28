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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dorcas.auth_app.R
import com.dorcas.auth_app.ui.theme.Pink80
import com.dorcas.auth_app.ui.theme.Purple80
import com.dorcas.auth_app.viewmodels.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController, authViewModel: AuthViewModel) {
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        ){
        Text(
            text = "Hey There!",
            fontSize = 24.sp,

            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp),

            )

        Text(
            text = "Create an Account",
            fontSize = 30.sp,

            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(),
        )
        OutlinedTextField(
            label ={ Text("Full name") },
            value = fullName ,
            onValueChange = {nameInput -> fullName =nameInput},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                focusedLabelColor = Purple80,
                cursorColor = Purple80
            ),

            keyboardOptions = KeyboardOptions.Default,
            modifier = Modifier
                .fillMaxWidth(),


            )

        OutlinedTextField(
            label ={ Text("Email") },
            value = userEmail ,
            onValueChange = {userEmailInput -> userEmail = userEmailInput},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                focusedLabelColor = Purple80,
                cursorColor = Purple80
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth(),


            )

        OutlinedTextField(
            label ={ Text("Password") },
            value = password ,
            onValueChange = {pwdInput -> password = pwdInput},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple80,
                focusedLabelColor = Purple80,
                cursorColor = Purple80
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            modifier = Modifier
                .fillMaxWidth(),



            trailingIcon = {
                val iconImage = if(passwordVisible){
                    Icons.Filled.Visibility
                }else{
                    Icons.Filled.VisibilityOff
                }
                var description = if (passwordVisible){
                    "Hide Password"
                }else{
                    "show password"
                }

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = iconImage, contentDescription = description )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                authViewModel.registerUser(
                    fullname = fullName,
                    email = userEmail,
                    password = password,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(20.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        )

        {
            Box(
                Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp)
                    .background(
                        brush = Brush.horizontalGradient(listOf(Pink80, Purple80)),
                        shape = RoundedCornerShape(40.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(text="Sign-Up",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Already Have An Account? Login",
            color = Color.Red,
            modifier= Modifier
                .clickable { navController.navigate("login") }
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter =  painterResource(id = R.drawable.google_icon),
            contentDescription = "Clickable Google Icon",
            modifier = Modifier.size(24.dp)

        )


        Spacer(modifier = Modifier.height(24.dp))

    }

}