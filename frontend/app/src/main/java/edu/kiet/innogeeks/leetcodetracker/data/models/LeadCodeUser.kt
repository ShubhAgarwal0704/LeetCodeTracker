package edu.kiet.innogeeks.leetcodetracker.data.models

data class LeetCodeUser(
    val leetcodeUrl: String,
    val status: String,
    val message: String,
    val totalSolved: Int,
    val totalQuestions: Int,
    val easySolved: Int,
    val totalEasy: Int,
    val mediumSolved: Int,
    val totalMedium: Int,
    val hardSolved: Int,
    val totalHard: Int,
    val acceptanceRate: Double,
    val ranking: Int,
    val contributionPoints: Int,
    val reputation: Int
)
