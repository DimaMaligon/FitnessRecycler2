package com.example.fitnessrecycler2.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class LessonItem (
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("place")
    @Expose
    var place: String,

    @SerializedName("coach_id")
    @Expose
    var coachId: String,

    var coachName: String,

    @SerializedName("startTime")
    @Expose
    var startTime: String,

    @SerializedName("endTime")
    @Expose
    var endTime: String,

    @SerializedName("date")
    @Expose
    var date: String,

    @SerializedName("appointment_id")
    @Expose
    var appointmentId: String,

    @SerializedName("service_id")
    @Expose
    var serviceId: String,

    @SerializedName("available_slots")
    @Expose
    var availableSlots: Int,

    @SerializedName("commercial")
    @Expose
    var commercial: Boolean,

    @SerializedName("client_recorded")
    @Expose
    var clientRecorded: Boolean,

    @SerializedName("is_cancelled")
    @Expose
    var isCancelled: Boolean,

    @SerializedName("tab")
    @Expose
    var tab: String,

    @SerializedName("color")
    @Expose
    var color: String,

    @SerializedName("tab_id")
    @Expose
    var tabId: Int,
)