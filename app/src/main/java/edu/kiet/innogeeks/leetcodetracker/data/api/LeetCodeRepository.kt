package edu.kiet.innogeeks.leetcodetracker.data.api

class LeetCodeRepository(private val api: LeetCodeApi) {
    suspend fun getDefaulters() = api.getDefaulters()
    suspend fun getLeaderboard() = api.getLeaderboard()
    suspend fun getUserProfile(username: String) = api.getUserProfile(username)
}