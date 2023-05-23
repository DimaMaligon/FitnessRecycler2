package com.example.fitnessrecycler2.recycler

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessrecycler2.R
import com.example.fitnessrecycler2.data.LessonItem
import com.example.fitnessrecycler2.databinding.LessonItemBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonHolder>() {
    var lessons = mutableListOf<LessonItem>()
    var dateTitle: String? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setLessonList(lessons: ArrayList<LessonItem>) {
        this.lessons = lessons.toMutableList()
        notifyDataSetChanged()
    }

    inner class LessonHolder(val binding: LessonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val binding = LessonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonHolder(binding)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        with(holder) {
            with(lessons[position]) {
                binding.startTime.text = startTime
                binding.name.text = name
                binding.endTime.text = endTime
                binding.coach.text = coachId
                binding.place.text = place
                var nowLessonDate = date
                if (nowLessonDate != dateTitle) {
                    binding.date.visibility = View.VISIBLE
                    dateTitle = nowLessonDate
                    binding.date.text = changeFormatDate(nowLessonDate)
                }
                binding.colorLabel.setBackgroundColor(Color.parseColor(color))
            }
        }
    }

    fun changeFormatDate(date: String): String {
        val formatterOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val locale = Locale("ru", "RU")
        val formatterTarget = DateTimeFormatter.ofPattern("EEEE, dd MMMM", locale)
        return LocalDate.parse(date, formatterOriginal).format(formatterTarget)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}