package com.example.notekeeper2

class DataManager {

    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_asynk", "Android Aync Programming and Services")
        courses.set(course.courseId, course)
    }

    fun getSizeOfCourses() {

    }
}