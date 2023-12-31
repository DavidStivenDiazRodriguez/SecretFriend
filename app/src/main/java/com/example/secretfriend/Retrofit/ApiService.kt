package com.example.secretfriend.Retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("user")
    suspend fun postUser(@Body user: User): Response<UserResponse>

    @GET("user")
    suspend fun getAllUser(): Response<List<UserResponse>>

    @GET("user/{id}")
    suspend fun getUserByUserName(@Path("id") username: String): Response<UserResponse>

}