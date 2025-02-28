package edu.kiet.innogeeks.leetcodetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kiet.innogeeks.leetcodetracker.viewmodels.LeetCodeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: LeetCodeViewModel = koinViewModel()) {
    val defaulters by viewModel.defaulters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState() // ✅ Loading state
    val errorMessage by viewModel.errorMessage.collectAsState() // ✅ Error state
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when {
                isLoading -> { // ✅ Show Loading Indicator
                    CircularProgressIndicator()
                }
                errorMessage.isNotEmpty() -> { // ✅ Show Snackbar on error
                    LaunchedEffect(errorMessage) {
                        snackbarHostState.showSnackbar(errorMessage)
                    }
                }
                defaulters.isEmpty() -> {
                    Text("No defaulters found", fontWeight = FontWeight.Bold)
                }
                else -> {
                    LazyColumn {
                        items(defaulters) { user ->
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Column(Modifier.padding(16.dp)) {
                                    Text(text = user.leetcodeUrl, fontWeight = FontWeight.Bold)
                                    Text(text = "Ranking: ${user.ranking}")
                                    Text(text = "Total Solved: ${user.totalSolved}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
