package com.example.fitnessrecycler2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessrecycler2.repo.Repository
import com.example.fitnessrecycler2.data.LessonItem
import com.example.fitnessrecycler2.data.LessonsListResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LessonViewModel(val repository: Repository) : ViewModel() {
    val lessonsList = MutableLiveData<ArrayList<LessonItem>>()
    lateinit var disposable: Disposable

    fun getAllLessons() {
        val responseLessons = repository.getLessons()
        val responseTrainers = repository.getTrainers()

        responseLessons.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getLessonsListObserver())
    }

    private fun getLessonsListObserver(): Observer<LessonsListResponse> {
        return object : Observer<LessonsListResponse> {
            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }

            override fun onNext(list: LessonsListResponse) {
                Log.d("list", list.lessons.toString())
                lessonsList.postValue(list.lessons)
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }
        }
    }
}