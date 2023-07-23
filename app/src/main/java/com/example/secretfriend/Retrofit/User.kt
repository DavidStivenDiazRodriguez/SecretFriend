package com.example.secretfriend.Retrofit

data class User(
    var username: String,
    var name: String,
    var lastName: String,
    var gifts: List<Gifts>
)

data class Gifts(
    var description: String,
    var price: Int
)

data class UserResponse(
    var username: String,
    var gifts: List<Gifts>
)
