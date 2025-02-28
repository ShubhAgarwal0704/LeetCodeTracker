package edu.kiet.innogeeks.leetcodetracker.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Leaderboard : Screen("leaderboard")
    object Profile : Screen("profile")
}
