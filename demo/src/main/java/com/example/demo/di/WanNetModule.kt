package com.example.demo.di

import com.example.demo.WanApiService
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
object WanNetModule {
    @Provides
    @Singleton
    fun provideService(): WanApiService = RetrofitManager.getApiService(
        WanApiService::class.java)

}