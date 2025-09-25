package com.example.pam.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.pam.ui.theme.PamTheme
import androidx.compose.ui.graphics.SolidColor

// Data class untuk menampung info user
data class User(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val phone: String,
    val address: String,
    val dob: String
)

@Composable
fun ProfileScreen(navController: NavController, user: User) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F5)) // Background abu-abu muda
    ) {
        // Bagian atas dengan background biru
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(Color(0xFF4256B8)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    text = "Profil",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(24.dp))
                // Avatar
                Box(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Avatar Profil",
                        modifier = Modifier.size(80.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Konten utama dalam Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 250.dp),
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Nama lengkap dan username
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "@${user.username}",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Detail informasi pengguna
                UserInfoItem(icon = Icons.Default.Email, label = "Email", value = user.email)
                UserInfoItem(icon = Icons.Default.Phone, label = "Telepon", value = user.phone)
                UserInfoItem(icon = Icons.Default.LocationOn, label = "Alamat", value = user.address)
                UserInfoItem(icon = Icons.Default.DateRange, label = "Tanggal Lahir", value = user.dob)

                Spacer(modifier = Modifier.weight(1f))

                // Tombol Keluar
                OutlinedButton(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = SolidColor(Color.Red),
                        width = 1.dp
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Red
                    )
                ) {
                    Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Keluar", tint = Color.Red)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Keluar", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Red)
                }
            }
        }
    }
}

// Reusable untuk menampilkan info user
@Composable
fun UserInfoItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PamTheme {
        ProfileScreen(
            navController = rememberNavController(),
            user = User(
                firstName = "Fauzan",
                lastName = "Raditya",
                username = "fznrdty",
                email = "fauzan@email.com",
                phone = "08123456789",
                address = "Malang, Indonesia",
                dob = "01/01/2000"
            )
        )
    }
}