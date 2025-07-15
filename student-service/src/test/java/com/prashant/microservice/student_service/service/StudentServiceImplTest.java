package com.prashant.microservice.student_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import com.example.common.model.StudentDetails;
import com.example.common.model.dto.StudentDetailsDto;
import com.prashant.microservice.student_service.repository.StudentRepo;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class StudentServiceImplTest {
	
	@Mock
	StudentRepo studentRepo;

	@InjectMocks
	StudentServiceImpl studentService;

	@ParameterizedTest
	@CsvSource({ "Amy,80,90,100,90", "Ghost,90,95,100,95" })
	void getStudentDetails_getsStudentDetails_whenStudentExistById(String name, int eng, int hin, int mar,
			int expectedPercentage) {

		int studentId = 5;

		StudentDetailsDto dto = new StudentDetailsDto(name, eng, hin, mar);
		StudentDetails saved = dto.toEntity();
		saved.setStudentId(studentId);
		saved.setStudentName(dto.getStudentName());
		saved.setEnglishMarks(dto.getEnglishMarks());
		saved.setHindiMarks(dto.getHindiMarks());
		saved.setMarathiMarks(dto.getMarathiMarks());

		when(studentRepo.findById(studentId)).thenReturn(Optional.of(saved));
		StudentDetailsDto result = studentService.getStudentDetails(studentId);

		assertEquals(name, result.getStudentName());
		assertEquals(eng, result.getEnglishMarks());
		assertEquals(expectedPercentage, result.getPercentage());
		verify(studentRepo, times(1)).findById(studentId);
	}
}