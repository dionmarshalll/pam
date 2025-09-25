package com.example.pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam.feature.AvatarScreen
import com.example.pam.feature.LoginScreen
import com.example.pam.feature.ProfileScreen
import com.example.pam.feature.RegisterScreen
import com.example.pam.feature.User
import com.example.pam.navigation.AppNavigation
import com.example.pam.ui.theme.PamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PamTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)

//                    NavHost(
//                        navController = navController,
//                        startDestination = "login"
//                    ) {
//                        composable("login") {
//                            LoginScreen(navController = navController)
//                        }
//                        composable("profile") {
//                           val user = User(
//                               firstName = "Fauzan",
//                               lastName = "Raditya",
//                               username = "fauzanraditya",
//                               email = "fauzan@gmail",
//                               phone = "0812345678",
//                               address = "Malang,Indonesia",
//                               dob = "2000-01-01"
//                           )
//                        }
//                        composable("avatar") {
//                            AvatarScreen(navController = navController)
//                        }
//                        composable("register") {
//                            RegisterScreen(navController = navController)
//                        }
//                    }
                }
            }
        }
    }
}
