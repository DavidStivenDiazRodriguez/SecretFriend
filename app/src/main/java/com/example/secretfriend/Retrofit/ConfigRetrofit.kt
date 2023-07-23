package com.example.secretfriend.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {

    companion object {

        //Construcción del cliente de Retrofit
        fun getRetrofitClient(): ApiService = Retrofit.Builder()
            .baseUrl("http://20.253.245.188:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}