package com.restapi.coursesapp.Dao;

import com.restapi.coursesapp.Entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
