package com.restapi.coursesapp.Controller;

import java.util.List;

import com.restapi.coursesapp.Entities.Course;
import com.restapi.coursesapp.Services.CourseServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseServices courseService;

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    // Get all courses
    @GetMapping("/Courses")
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    // Get single course by id
    @GetMapping("/Courses/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
        Course course = null;
        try {
            course = courseService.getCourse(Integer.parseInt(courseId));
            return ResponseEntity.status(HttpStatus.CREATED).body(course);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/Courses")
    public Course addCourse(@RequestBody Course course) {

        Course addedCourse = courseService.addCourse(course);
        return addedCourse;
    }

    @PutMapping("/Courses")
    public ResponseEntity<String> update(@RequestBody Course course) {
        try {
            courseService.update(course);
            return ResponseEntity.ok("Updated sucessfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }

    }

    @DeleteMapping("/Courses/{courseId}")
    public ResponseEntity<String> delete(@PathVariable String courseId) {

        try {

            courseService.delete(Integer.parseInt(courseId));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletion sucessfull");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
