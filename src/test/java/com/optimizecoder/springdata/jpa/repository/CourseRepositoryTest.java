package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Course;
import com.optimizecoder.springdata.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("rajeev")
                .lastName("bvs")
                .build();
        Course course = Course.builder()
                .credit(2)
                .title("Dotnet")
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPages(){

        Pageable pageWithToSize =  PageRequest.of(0,2);
        List<Course> courses = courseRepository.findAll(pageWithToSize).getContent();
        Long totalElements = courseRepository.findAll(pageWithToSize).getTotalElements();
        long totalPages = courseRepository.findAll(pageWithToSize).getTotalPages();
    }


    // if we have multiple pages.
//    Page<Course> page = courseRepository.findAll(pageable);
//
//    List<Course> allCourses = new ArrayList<>(page.getContent());
//
//while (page.hasNext()) {
//        pageable = pageable.next();
//        page = courseRepository.findAll(pageable);
//        allCourses.addAll(page.getContent());
//    }
    /*
    *
    * */
    @Test
    public void findPageOnSorting() {
        Pageable sortingPages = PageRequest.of(0, 2, Sort.by("title"));
        List<Course> courses = courseRepository.findAll(sortingPages).getContent();
        //List<Course> courses = courseRepository.findAll(sortingPages).stream().toList();

        Pageable sortingPagesByNameDescendingOrder = PageRequest.of(0, 2, Sort.by("title").descending());
        courses = courseRepository.findAll(sortingPagesByNameDescendingOrder).getContent();

        Pageable sortingPagesByNameDescendingOrderAndCredit = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        courses = courseRepository.findAll(sortingPagesByNameDescendingOrderAndCredit).getContent();

    }
}