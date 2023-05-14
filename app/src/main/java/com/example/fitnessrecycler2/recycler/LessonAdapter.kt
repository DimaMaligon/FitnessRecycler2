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

    inner class LessonHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = LessonItemBinding.bind(item)
        fun bind(lesson: LessonItem) = with(binding) {
            startTime.text = lesson.startTime
            name.text = lesson.name
            endTime.text = lesson.endTime
            coach.text = lesson.coachId
            place.text = lesson.place
            var nowLessonDate = lesson.date
            if(nowLessonDate != dateTitle){
                date.visibility = View.VISIBLE
                dateTitle = nowLessonDate
                date.text = changeFormatDate(nowLessonDate)
            }
            colorLabel.setBackgroundColor(Color.parseColor(lesson.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.lesson_item, parent, false)
        return LessonHolder(item = viewItem)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        holder.bind(lessons[position])
    }

    fun changeFormatDate(date: String): String{
        val formatterOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val locale = Locale("ru", "RU")
        val formatterTarget = DateTimeFormatter.ofPattern("EEEE, dd MMMM", locale)
        return LocalDate.parse(date, formatterOriginal).format(formatterTarget)
    }
}