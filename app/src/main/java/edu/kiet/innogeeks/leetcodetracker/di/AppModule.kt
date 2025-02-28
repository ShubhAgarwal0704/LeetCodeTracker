package edu.kiet.innogeeks.leetcodetracker.di

import edu.kiet.innogeeks.leetcodetracker.data.api.LeetCodeApi
import edu.kiet.innogeeks.leetcodetracker.data.api.LeetCodeRepository
import edu.kiet.innogeeks.leetcodetracker.viewmodels.LeetCodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://leetcode-leaderboard-rvmh.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LeetCodeApi::class.java)
    }
}

val repositoryModule = module {
    single { LeetCodeRepository(get()) }
}

val viewModelModule = module {
    viewModel { LeetCodeViewModel(get()) }
}


