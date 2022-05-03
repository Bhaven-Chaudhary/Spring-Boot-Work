package com.restapi.coursesapp.Services;

import java.util.List;

import com.restapi.coursesapp.Entities.Course;

public interface CourseServices {

    public List<Course> getAllCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public void update(Course course);

    public void delete(long courseId);

}
