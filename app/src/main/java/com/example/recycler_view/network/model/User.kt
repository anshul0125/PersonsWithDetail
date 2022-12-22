package com.example.recycler_view.network.model

data class User(
    val avatar_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val type: String,
    val url: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val location: Any,
)
