package com.example.pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pam.ui.theme.PamTheme

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Placeholder untuk Avatar
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = "Avatar Profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nama dan Email Pengguna
        Text(
            text = "Nama Pengguna",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "email@pengguna.com",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol Edit Avatar
        Button(
            onClick = { navController.navigate("avatar") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Avatar")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Edit Avatar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Logout
        OutlinedButton(
            onClick = {
                // Kembali ke login dan hapus semua halaman sebelumnya dari tumpukan
                navController.navigate("login") {
                    popUpTo(0)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Logout")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PamTheme {
        ProfileScreen(navController = rememberNavController())
    }
}
