package com.example.fitnessrecycler2.api

import com.example.fitnessrecycler2.data.LessonsListResponse
import com.example.fitnessrecycler2.data.TrainersListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiFitness {
    @GET("/schedule/get_v3/?club_id=2")
    fun getJsonLessons(): Observable<LessonsListResponse>

    @GET("/schedule/get_v3/?club_id=2")
    fun getJsonTrainers(): Observable<TrainersListResponse>

    companion object {
        fun getRetrofit(): ApiFitness {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://olimpia.fitnesskit-admin.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
           return retrofit.create(ApiFitness::class.java)
        }
    }
}