package com.prashant.microservice.teacher_service.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.common.model.dto.StudentDetailsDto;
import com.example.common.model.dto.TeacherRequestDto;
import com.example.common.model.dto.TeacherResponseDto;

public interface TeacherService {

	
	public TeacherResponseDto createTeacher(TeacherRequestDto dto);
	public TeacherResponseDto updateTeacher(Integer teacherId, TeacherRequestDto dto);
	public String deleteTeacher(Integer teacherId);
	public Page<TeacherResponseDto> getTeachers(Pageable pageable);
	
	
	public StudentDetailsDto createStudent(StudentDetailsDto dto);
	public StudentDetailsDto updateStudent(Integer studentId,StudentDetailsDto dto);
	public String deleteStudent(Integer studentId);
	public Page<StudentDetailsDto> getStudents(Pageable pageable);
}
