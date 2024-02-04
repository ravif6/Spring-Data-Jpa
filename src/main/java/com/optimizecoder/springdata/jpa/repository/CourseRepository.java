package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
