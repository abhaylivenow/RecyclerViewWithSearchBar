package com.example.recyclerviewwithsearchbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private var courseList: List<CourseModel>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var courseName: TextView? = null
        var coursePrice: TextView? = null
        var courseDes: TextView? = null
        var courseImage: ImageView? = null

        init {
            courseName = itemView.findViewById(R.id.text_course_name)
            coursePrice = itemView.findViewById(R.id.text_course_price)
            courseDes = itemView.findViewById(R.id.text_course_des)
            courseImage = itemView.findViewById(R.id.image)
        }
    }

    fun filterList(filterList: List<CourseModel>) {
        courseList = filterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemiew =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_course, parent, false)
        return ViewHolder(itemiew)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courseList[position]

        holder.courseDes?.text = course.courseDes
        holder.courseName?.text = course.courseName
        holder.coursePrice?.text = course.coursePrice.toString()
        holder.courseImage?.setImageResource(course.courseImage)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}