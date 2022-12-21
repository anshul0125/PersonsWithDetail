package com.example.recycler_view

data class InPerson(
    val followers: Int,
    val following: Int,
    val id: Int,
    val location: Any,
    val login: String,
    val name: String,
    val node_id: String,
    val type: String,
    val url: String
)