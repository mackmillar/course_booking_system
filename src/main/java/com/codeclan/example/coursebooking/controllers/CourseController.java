package com.codeclan.example.coursebooking.controllers;


import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCoursesByRating(
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "name")String name
            ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}