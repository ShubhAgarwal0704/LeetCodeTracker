package edu.kiet.innogeeks.leetcodetracker.hosting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import edu.kiet.innogeeks.leetcodetracker.ui.screens.MainScreen
import edu.kiet.innogeeks.leetcodetracker.ui.theme.LeetCodeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeetCodeTrackerTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MainScreen(modifier = Modifier.padding(innerPadding), navController)
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LeetCodeTrackerTheme {
        AppContent()
    }
}
