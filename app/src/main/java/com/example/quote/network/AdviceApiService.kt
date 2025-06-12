package com.example.quote.network

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface AdviceApiService{
    @GET("advice")
    suspend fun getadvice():AdviceResponse
}

object RetrofitInstance{
    private const val BASE_URL ="https://api.adviceslip.com/"

    val api:AdviceApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdviceApiService::class.java)
    }
}