package com.mager.gamer.data.model.remote.register


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)