package com.example.recyclerviewwithsearchbar

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var searchView: SearchView
    var listOfCourse = mutableListOf<CourseModel>()
    var rvAdapter = Adapter(listOfCourse)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course1_image,
                courseDes = "This is the course description....",
                courseName = "Java Spring Boot",
                coursePrice = 1000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course2_image,
                courseDes = "This is the course description....",
                courseName = "Android developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course3_image,
                courseDes = "This is the course description....",
                courseName = "Web developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course4_image,
                courseDes = "This is the course description....",
                courseName = "Machine Learning",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course5_image,
                courseDes = "This is the course description....",
                courseName = "Backend developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course1_image,
                courseDes = "This is the course description....",
                courseName = "FullStack developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course2_image,
                courseDes = "This is the course description....",
                courseName = "Data Scientist",
                coursePrice = 1000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course3_image,
                courseDes = "This is the course description....",
                courseName = "UI/UX Developer",
                coursePrice = 3000
            )
        )

        listOfCourse.add(
            CourseModel(
                courseImage = R.drawable.course4_image,
                courseDes = "This is the course description....",
                courseName = "Software Testing",
                coursePrice = 3000
            )
        )

        rv = findViewById(R.id.rv)
        searchView = findViewById(R.id.search_view)
        searchView.queryHint = "Search Courses"
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = rvAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filter(p0)
                return false
            }
        })
    }

    fun filter(text: String?) {
        val filteredList = mutableListOf<CourseModel>()

        for(course in listOfCourse) {
            if(course.courseName.lowercase().contains(text!!.lowercase())) {
                filteredList.add(course)
            }
        }

        if(filteredList.isEmpty()) {
            Toast.makeText(this,"Nothing found",Toast.LENGTH_SHORT).show()
        } else {
            rvAdapter.filterList(filteredList)
        }
    }
}












