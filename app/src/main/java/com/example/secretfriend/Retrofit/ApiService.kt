package com.example.secretfriend.Retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("user")
    suspend fun postUser(@Body user: User): Response<UserResponse>

}