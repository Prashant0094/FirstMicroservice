package com.prashant.microservice.auth_service.temporaryrepo;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.common.model.TeacherDetails;


@Repository
public interface TeacherRepo extends JpaRepository<TeacherDetails, Integer> {

	boolean existsByTeacherEmail(String teacherEmail);
	
	Optional<TeacherDetails> findByTeacherEmail(String teacherEmail);
	
	Page<TeacherDetails> findAll(Pageable pageable);
	
	

}
