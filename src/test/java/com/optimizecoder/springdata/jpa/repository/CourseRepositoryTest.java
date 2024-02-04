package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository courseRepository;

    @Test
    public void saveCourse()
    {
        Course course = Course.builder()
                .credit(4)
                .title("Java")
                .build();
        courseRepository.save(course);
    }

    @Test
    public  void printCourses(){
        List<Course> courseList = courseRepository.findAll();
    }
}