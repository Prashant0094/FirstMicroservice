package com.prashant.microservice.student_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.model.StudentDetails;
import com.example.common.model.dto.StudentDetailsDto;
import com.example.common.model.exception.ResourceNotFoundException;
import com.prashant.microservice.student_service.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired 
	private StudentRepo studentrepo;
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Override
	public StudentDetailsDto getStudentDetails(Integer studentId) {
		
		StudentDetails student = studentrepo.findById(studentId)
				.orElseThrow (() -> new ResourceNotFoundException("The student with ID " + studentId + " does not exist!"));
		log.info("Student details displayed for Id {}" ,studentId);
		return StudentDetailsDto.fromEntity(student);
	}

}
