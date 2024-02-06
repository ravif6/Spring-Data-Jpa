package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Course;
import com.optimizecoder.springdata.jpa.entity.CourseMaterial;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void saveCourseMaterial(){

        // added beacause optional = false to course in courseMaterial

        Course course = Course.builder()
                .title("Spring")
                .credit(3)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.w3school.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void getAllCourseMaterials(){
        List<CourseMaterial>  courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }


}