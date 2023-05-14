package com.example.fitnessrecycler2.data


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class TrainersListResponse(val trainers: ArrayList<TrainerItem>)

data class TrainerItem(
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("full_name")
    @Expose
    var fullName: String,
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("image_url")
    @Expose
    var imageUrl: String,
    @SerializedName("image_url_medium")
    @Expose
    var imageUrlMedium: String,
    @SerializedName("image_url_small")
    @Expose
    var imageUrlSmall: String,
    @SerializedName("last_name")
    @Expose
    var lastName: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("position")
    @Expose
    var position: String
)