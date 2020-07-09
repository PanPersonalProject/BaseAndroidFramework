package com.example.test.di

import com.example.test.TestApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pan.lib.common_lib.retrofit.RetrofitManager
import javax.inject.Singleton

/**
 * author: Pan
 * date: 2020/7/9
 */
@InstallIn(ApplicationComponent::class)
@Module
object TestNetWorkModule {
    @Provides
    @Singleton
    fun provideService(): TestApiService = RetrofitManager.getApiService(TestApiService::class.java)

}