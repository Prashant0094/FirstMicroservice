package com.prashant.microservice.student_service.service;

import com.example.common.model.dto.StudentDetailsDto;

public interface StudentService {
	
	public StudentDetailsDto getStudentDetails(Integer studentId);

}
