package com.example.secretfriend.Repository

import android.content.Context
import android.widget.Toast
import com.example.secretfriend.Retrofit.ConfigRetrofit
import com.example.secretfriend.Retrofit.User
import com.google.gson.Gson

class RegisterRepository(private val context: Context) {

    private val retrofit = ConfigRetrofit.getRetrofitClient()

    //Envia la petición para guardar la información de un nuevo registro de usuario
    suspend fun registerUser(user: User) {
        retrofit.postUser(user)
        Toast.makeText(context, "Usuario guardado con éxito", Toast.LENGTH_LONG).show()
    }

    //Obtiene la lista de participantes y retorna una lista con solo los username
    suspend fun getFriend(): List<String> {
        val users = retrofit.getAllUser()
        return users.body()!!.map { it.username }
    }
}