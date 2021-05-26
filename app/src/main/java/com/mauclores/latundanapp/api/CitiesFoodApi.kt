package com.mauclores.latundanapp.api

import retrofit2.http.GET

interface CitiesFoodApi {

    companion object {
        const val BASE_URL = "https://api.npoint.io/"
    }

    @GET("a2b63ef226c08553b2f9")
    suspend fun getCitiesAndFood(): CitiesFoodResponse
}