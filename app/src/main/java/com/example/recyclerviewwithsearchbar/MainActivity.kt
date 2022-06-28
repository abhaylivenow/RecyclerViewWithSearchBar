package com.example.recyclerviewwithsearchbar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

        // Setting up color of action bar
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#0F9D58")))

        // init views
        rv = findViewById(R.id.rv)
        searchView = findViewById(R.id.search_view)
        // set hint iver search view
        searchView.queryHint = "Search Courses"

        // adding dummy data list that is used by adapter for inflating recycler view
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

        // setting up recycler view adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = rvAdapter

        // setting query text listener for search view
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            // this method is invoked everytime when text is changed over the search view
            override fun onQueryTextChange(p0: String?): Boolean {
                // filter method will search the string entered by user
                // and if there is any matching element it will add to recycler view
                filter(p0)
                return false
            }
        })
    }

    fun filter(text: String?) {
        val filteredList = mutableListOf<CourseModel>()

        // search matching name in the listOfCourse
        // if exist, then add it to filtered list
        for (course in listOfCourse) {
            if (course.courseName.lowercase().contains(text!!.lowercase())) {
                filteredList.add(course)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show()
        } else {
            rvAdapter.filterList(filteredList)
        }
    }
}












