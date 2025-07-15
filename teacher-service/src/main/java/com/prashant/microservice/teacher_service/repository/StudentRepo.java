package com.prashant.microservice.teacher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.common.model.StudentDetails;

@Repository
public interface StudentRepo extends JpaRepository<StudentDetails, Integer>{

}
