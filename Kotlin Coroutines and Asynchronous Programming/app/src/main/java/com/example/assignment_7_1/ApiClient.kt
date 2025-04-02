package com.example.assignment_7_1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient
{
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val apiService: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}