package com.example.gameratis

data class User(
    var username: String = "",
    var password: String = "",
    var email: String = ""
) {
    constructor() : this("", "", "")
}
