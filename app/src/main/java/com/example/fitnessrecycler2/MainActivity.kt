package com.example.fitnessrecycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessrecycler2.api.ApiFitness
import com.example.fitnessrecycler2.databinding.ActivityMainBinding
import com.example.fitnessrecycler2.recycler.LessonAdapter
import com.example.fitnessrecycler2.repo.Repository
import com.example.fitnessrecycler2.viewmodel.LessonViewModel
import com.example.fitnessrecycler2.viewmodel.LessonViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var lessonViewModel: LessonViewModel
    private val apiFitness = ApiFitness.getRetrofit()
    private val adapter = LessonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lessonViewModel =
            ViewModelProvider(this, LessonViewModelFactory(Repository(apiFitness)))[LessonViewModel::class.java]
        lessonViewModel.lessonsList.observe(this) {
            adapter.setLessonList(it)
        }
        binding.apply {
            recyclerLessons.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerLessons.adapter = adapter
            lessonViewModel.getAllLessons()
        }

    }

    override fun onDestroy() {
        lessonViewModel.disposable.dispose()
        super.onDestroy()
    }
}