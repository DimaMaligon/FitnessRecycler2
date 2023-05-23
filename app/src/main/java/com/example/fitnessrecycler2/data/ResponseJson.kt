package com.example.fitnessrecycler2.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseJson(
    @SerializedName("lessons")
    @Expose
    val lessons: ArrayList<LessonItem>,

    @SerializedName("trainers")
    @Expose
    val trainers: ArrayList<TrainerItem>
)