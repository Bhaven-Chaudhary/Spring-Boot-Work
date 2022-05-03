package com.restapi.coursesapp.Services;

import java.util.List;

import com.restapi.coursesapp.Dao.CourseDao;
import com.restapi.coursesapp.Entities.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServicesImpl implements CourseServices {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {

        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {

        // return list.stream().filter(course -> course.getId() ==
        // courseId).findFirst().get();

        return courseDao.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {
        Course savedCourse = courseDao.save(course);
        return savedCourse;
    }

    @Override
    public void update(Course course) {

        // list = list.stream().map(obj -> {
        // if (obj.getId() == course.getId())
        // obj = course;

        // return obj;
        // }).collect(Collectors.toList());

        courseDao.save(course);
    }

    @Override
    public void delete(long courseId) {
        // list = list.stream().filter(course -> course.getId() !=
        // courseId).collect(Collectors.toList());
        Course course = courseDao.getById(courseId);
        courseDao.delete(course);
    }

}
