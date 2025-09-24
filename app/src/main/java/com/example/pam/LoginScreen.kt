package com.example.pam

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pam.ui.theme.PamTheme





@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selamat Datang", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Masuk untuk melanjutkan", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(48.dp))


        // Input field untuk Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Ikon Email"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Ikon Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Login
        Button(
            onClick = {
                // Logika untuk login tambahin sini
                navController.navigate("profile")

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol ke register
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Belum punya akun? ")
            TextButton(onClick = { /* Navigasi ke register */ }) {
                Text("Daftar di sini")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PamTheme {
        LoginScreen(navController = rememberNavController())
    }
}
