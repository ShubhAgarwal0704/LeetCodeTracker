package edu.kiet.innogeeks.leetcodetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kiet.innogeeks.leetcodetracker.viewmodels.LeetCodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LeaderboardScreen(viewModel: LeetCodeViewModel = koinViewModel()) { // ✅ Inject ViewModel
    val leaderboard = viewModel.leaderboard.collectAsState().value

    LazyColumn {
        items(leaderboard) { user -> // ✅ Fixed missing import
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(text = user.leetcodeUrl, fontWeight = FontWeight.Bold)
                    Text(text = "Ranking: ${user.ranking}")
                }
            }
        }
    }
}
