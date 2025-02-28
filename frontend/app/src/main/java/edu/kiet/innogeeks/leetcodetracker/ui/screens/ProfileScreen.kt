package edu.kiet.innogeeks.leetcodetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.kiet.innogeeks.leetcodetracker.viewmodels.LeetCodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(viewModel: LeetCodeViewModel = koinViewModel()) { // ✅ Inject ViewModel
    val profile = viewModel.profile.collectAsState().value

    profile?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "LeetCode URL: ${it.leetcodeUrl}")
            Text(text = "Ranking: ${it.ranking}")
        }
    }
}
