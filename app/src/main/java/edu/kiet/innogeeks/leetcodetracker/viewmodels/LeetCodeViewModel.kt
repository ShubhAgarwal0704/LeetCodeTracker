package edu.kiet.innogeeks.leetcodetracker.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.kiet.innogeeks.leetcodetracker.data.api.LeetCodeRepository
import edu.kiet.innogeeks.leetcodetracker.data.models.LeetCodeUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class LeetCodeViewModel(private val repository: LeetCodeRepository) : ViewModel() {

    private val _defaulters = MutableStateFlow<List<LeetCodeUser>>(emptyList())
    val defaulters: StateFlow<List<LeetCodeUser>> = _defaulters

    private val _leaderboard = MutableStateFlow<List<LeetCodeUser>>(emptyList())
    val leaderboard: StateFlow<List<LeetCodeUser>> = _leaderboard

    private val _profile = MutableStateFlow<LeetCodeUser?>(null)
    val profile: StateFlow<LeetCodeUser?> = _profile

    init {
        fetchDefaulters()
        fetchLeaderboard()
    }

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    init {
        fetchDefaulters()
    }

    fun fetchDefaulters() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""

            try {
                _defaulters.value = repository.getDefaulters()
            } catch (e: SocketTimeoutException) {
                _errorMessage.value = "Network timeout. Please try again."
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchLeaderboard() {
        viewModelScope.launch {
            _leaderboard.value = repository.getLeaderboard()
        }
    }

    fun fetchProfile(username: String) {
        viewModelScope.launch {
            _profile.value = repository.getUserProfile(username)
        }
    }
}
