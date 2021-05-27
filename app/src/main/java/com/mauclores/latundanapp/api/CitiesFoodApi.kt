package com.mauclores.latundanapp.api

import retrofit2.http.GET

interface CitiesFoodApi {

    companion object {
        const val BASE_URL = "https://api.npoint.io/"
    }

    @GET("7fa8344c8749d39e7cdc")
    suspend fun getCitiesAndFood(): CitiesFoodResponse
}