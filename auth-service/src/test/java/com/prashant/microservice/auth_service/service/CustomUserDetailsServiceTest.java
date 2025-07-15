package com.prashant.microservice.auth_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.TestPropertySource;

import com.example.common.model.TeacherDetails;
import com.example.common.model.dto.TeacherRequestDto;
import com.prashant.microservice.auth_service.security.CustomUserDetailsService;
import com.prashant.microservice.auth_service.temporaryrepo.TeacherRepo;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class CustomUserDetailsServiceTest {
	
	@InjectMocks
	private CustomUserDetailsService service1;
	
	@Mock
	private TeacherRepo teacherRepo;
	
	@Mock
	private UserDetails userDetails;
	
	@Test
	void loadUserByUsernameShouldLoadUserWhenEmailExist() {
		int teacherId = 1;
		TeacherRequestDto teacherDto = new TeacherRequestDto("Amy","Amy@email.com","Pass");
		TeacherDetails teacher = teacherDto.toEntity();
		teacher.setTeacherId(teacherId);
		
		when(teacherRepo.findByTeacherEmail("Amy@email.com")).thenReturn(Optional.of(teacher));
		UserDetails response = service1.loadUserByUsername("Amy@email.com");
		assertEquals("Amy@email.com", response.getUsername());
		
	}
}
