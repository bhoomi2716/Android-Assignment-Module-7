package com.example.assignment_7_1

import retrofit2.http.GET

interface ApiInterface
{
    @GET("posts")
    suspend fun getPosts(): List<Model>
}