package com.optimizecoder.springdata.jpa.repository;

import com.optimizecoder.springdata.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContains(String firstName);

    List<Student> findByLastNameNotNull();
// Names in guardian model is given wantedly
    List<Student> findByGuardianNames(String guardianName);

    Student findByEmailId(String emailId);

    @Query("select s from Student s where s.emailId =?1")
    Student findByEmailAddress(String emailId);

    @Query(
            value = "Select s.first_name from tbl_student s where s.email_address =:emailId" ,
            nativeQuery = true
    )
    String findStudentFirstNameByEmailAddress(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateFirstNameByEmailAddress(String firstName , String emailAddress);


}


