package com.example.fitnessrecycler2.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessrecycler2.repo.Repository
import com.example.fitnessrecycler2.data.LessonItem
import com.example.fitnessrecycler2.data.ResponseJson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LessonViewModel(val repository: Repository) : ViewModel() {
    val lessonsList = MutableLiveData<ArrayList<LessonItem>>()
    lateinit var disposable: Disposable

    @SuppressLint("CheckResult")
    fun getAllLessons() {
        val responseFitness = repository.getFitnessData()

        responseFitness
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.computation())
            .map { response ->
                response.lessons.sortWith(compareBy<LessonItem> { it.date }.thenBy { it.startTime })
                response.lessons.map { lesson ->
                    response.trainers.map { trainer ->
                        if (trainer.id == lesson.coachId) {
                            lesson.coachId = trainer.name
                        }
                    }
                }
                response.lessons
            }
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getLessonsListObserver())


    }

    private fun getLessonsListObserver(): Observer<List<LessonItem>> {
        return object : Observer<List<LessonItem>> {
            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(list: List<LessonItem>) {
                Log.d("list-lessons", list.toString())
                lessonsList.postValue(list as ArrayList<LessonItem>?)
            }
        }
    }
}