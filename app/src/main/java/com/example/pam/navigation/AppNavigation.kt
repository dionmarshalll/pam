package com.example.pam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pam.feature.LoginScreen
import com.example.pam.feature.ProfileScreen
import com.example.pam.feature.RegisterScreen
import com.example.pam.feature.User

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Login
    )
    {
        composable(NavigationRoutes.Login) {
            LoginScreen(navController=navController)
        }
        composable(NavigationRoutes.Profile){
            val user = User(
                firstName = "Fauzan",
                lastName = "Raditya",
                username = "fznrdty",
                email = "fauzan@email.com",
                phone = "08123456789",
                address = "Malang, Indonesia",
                dob = "01/01/2000"
            )
            ProfileScreen(navController=navController, user = user)
        }
//        composable(NavigationRoutes.Avatar){
//            AvatarScreen(navController=navController)
//        }
        composable(NavigationRoutes.Register){
            RegisterScreen(navController=navController)

        }
    }

}