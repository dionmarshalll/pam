package com.example.pam.navigation

object NavigationRoutes {
    const val Login = "login"
    const val Register = "register"
    const val Profile = "profile"
    object WithArgs{
        const val PROFILE_WITH_ID = "profile/{id}"
        fun createRoute(id: Int) = "profile/$id"
    }
}
