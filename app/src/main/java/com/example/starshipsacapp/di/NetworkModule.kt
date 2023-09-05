package com.example.starshipsacapp.di

import com.example.starshipsacapp.core.RetrofitHelper
import com.example.starshipsacapp.data.network.StarshipApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

//@Module
//@InstallIn(SingletonComponent::class)
object NetworkModule {
/*
    private val httpClient = OkHttpClient.Builder()
        .callTimeout(2, TimeUnit.MINUTES)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/starships/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideStarshipApiClient(retrofit: Retrofit): StarshipApiClient{
        return retrofit.create(StarshipApiClient::class.java)
    }

 */
}