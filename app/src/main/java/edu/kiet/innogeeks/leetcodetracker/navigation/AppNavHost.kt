package edu.kiet.innogeeks.leetcodetracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.kiet.innogeeks.leetcodetracker.ui.screens.*
import edu.kiet.innogeeks.leetcodetracker.viewmodels.LeetCodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val viewModel = koinViewModel<LeetCodeViewModel>() // ✅ Inject ViewModel in NavGraph

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(viewModel) } // ✅ Pass ViewModel
        composable(Screen.Leaderboard.route) { LeaderboardScreen(viewModel) } // ✅ Pass ViewModel
        composable(Screen.Profile.route) { ProfileScreen(viewModel) } // ✅ Pass ViewModel
    }
}
