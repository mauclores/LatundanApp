package com.mauclores.latundanapp.di

import android.app.Application
import androidx.room.Room
import com.mauclores.latundanapp.api.CitiesFoodApi
import com.mauclores.latundanapp.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(CitiesFoodApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCitiesFoodApi(retrofit: Retrofit): CitiesFoodApi =
        retrofit.create(CitiesFoodApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app_database")
            .build()
}