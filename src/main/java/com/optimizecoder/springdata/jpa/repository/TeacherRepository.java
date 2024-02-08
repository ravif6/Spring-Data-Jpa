package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
