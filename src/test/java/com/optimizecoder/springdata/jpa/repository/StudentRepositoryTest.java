package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Guardian;
import com.optimizecoder.springdata.jpa.entity.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ravi@gmail.com")
                .firstName("ravikiran")
                .lastName("yasa")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guardian@gmil.com")
                .mobile("7894561234")
                .names("guardian")
                .build();
        Student student = Student.builder()
                .emailId("ravikiranr@gmail.com")
                .firstName("ravikiran")
                .lastName("yasa")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public  void printAllStudents()
    {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void printByFistName(){
        List<Student>  students = studentRepository.findByFirstName("ravikiran");
        System.out.println(students);
    }

    @Test
    public void printByFirstNameContains(){
        List<Student>  students = studentRepository.findByFirstNameContains("ravikiran");
        System.out.println(students);
    }

    @Test
    @DisplayName("")
    public void printByLastNameNotNull(){
        List<Student>  students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    @DisplayName("test by guardian Name")
    public void printByGuardianNames(){
        List<Student>  students = studentRepository.findByGuardianNames("guardian");
        System.out.println(students);
    }

    @Test
    public void printByEmailId(){
//        Student student = studentRepository.findByEmailId("ravikiran@gmail.com");
        Student student = studentRepository.findByEmailAddress("ravikiran@gmail.com");
        System.out.println(student);
    }

    @Test
    public void findStudentFirstNameByEmailAddress(){
        String name = studentRepository.findStudentFirstNameByEmailAddress("ravikiran@gmail.com");
        System.out.println(name);
    }

    @Test
    public void updateStudentNameByEmailAddress() {
        int val = studentRepository.updateFirstNameByEmailAddress("ravikiranreddy","ravikiran@gmail.com");
        System.out.println(val);
    }

}