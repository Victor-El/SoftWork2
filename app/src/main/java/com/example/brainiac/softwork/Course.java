package com.example.brainiac.softwork;

public class Course {

    private String mCourseName;
    private String mCourseDesc;


    public Course(String CourseName, String CourseDesc) {
        mCourseName = CourseName;
        mCourseDesc = CourseDesc;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public String getmCourseDesc() {
        return mCourseDesc;
    }

}
