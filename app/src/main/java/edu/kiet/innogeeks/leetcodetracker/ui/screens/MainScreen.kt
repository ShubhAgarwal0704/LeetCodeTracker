package edu.kiet.innogeeks.leetcodetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.kiet.innogeeks.leetcodetracker.navigation.AppNavHost
import edu.kiet.innogeeks.leetcodetracker.ui.compenents.BottomNavigationBar

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavHost(navController)
        }
    }
}
