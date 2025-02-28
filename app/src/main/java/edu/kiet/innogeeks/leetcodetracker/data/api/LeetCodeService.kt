package edu.kiet.innogeeks.leetcodetracker.data.api

import edu.kiet.innogeeks.leetcodetracker.data.models.LeetCodeUser
import retrofit2.http.GET
import retrofit2.http.Path

interface LeetCodeApi {
    @GET("api/v0/default")
    suspend fun getDefaulters(): List<LeetCodeUser>

    @GET("api/v0/leaderboard")
    suspend fun getLeaderboard(): List<LeetCodeUser>

    @GET("api/v0/{leetcode_user_name}")
    suspend fun getUserProfile(@Path("leetcode_user_name") username: String): LeetCodeUser
}
