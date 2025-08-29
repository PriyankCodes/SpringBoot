package com.tss.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tss.jpa.dto.StudentRequestDto;
import com.tss.jpa.dto.StudentResponseDto;
import com.tss.jpa.dto.StudentResponsePage;
import com.tss.jpa.entity.Student;
import com.tss.jpa.exception.StudentApiException;
import com.tss.jpa.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ModelMapper mapper;

	private void validateStudent(StudentRequestDto studentDto) {
		if (studentDto.getFirstName() == null || !studentDto.getFirstName().matches("^[A-Za-z]{2,30}$")) {
			throw new StudentApiException("Invalid first name. Must be 2-30 letters only.");
		}
		if (studentDto.getLastName() == null || !studentDto.getLastName().matches("^[A-Za-z]{2,30}$")) {
			throw new StudentApiException("Invalid last name. Must be 2-30 letters only.");
		}
		if (studentDto.getRollNumber() <= 0 || studentDto.getRollNumber() > 9999) {
			throw new StudentApiException("Invalid roll number. Must be between 1 and 9999.");
		}
		if (studentDto.getEmail() == null
				|| !Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", studentDto.getEmail())) {
			throw new StudentApiException("Invalid email format.");
		}
		if (studentDto.getAge() <= 5 || studentDto.getAge() > 100) {
			throw new StudentApiException("Invalid age. Must be between 6 and 100.");
		}
	}

	private void validatePagination(int pagesize, int pageno) {
		if (pagesize <= 0) {
			throw new StudentApiException("Page size must be greater than 0.");
		}
		if (pageno < 0) {
			throw new StudentApiException("Page number cannot be negative.");
		}
	}

	@Override
	public StudentResponsePage readAllStudents(int pagesize, int pageno) {
		validatePagination(pagesize, pageno);

		Pageable pageable = PageRequest.of(pageno, pagesize);
		Page<Student> studentPage = studentRepo.findAll(pageable);

		StudentResponsePage studentResponse = new StudentResponsePage();
		studentResponse.setTotalElements(studentPage.getTotalElements());
		studentResponse.setSize(studentPage.getSize());
		studentResponse.setTotalPages(studentPage.getTotalPages());
		studentResponse.setLastPage(studentPage.isLast());

		List<StudentResponseDto> contents = new ArrayList<>();
		for (Student student : studentPage.getContent()) {
			contents.add(studentToStudentResponseDto(student));
		}
		studentResponse.setContents(contents);
		return studentResponse;
	}

	@Override
	public StudentResponseDto addNewStudent(StudentRequestDto studentDto) {
		validateStudent(studentDto);
		Student student = mapper.map(studentDto, Student.class);
		Student dbStudent = studentRepo.save(student);
		return mapper.map(dbStudent, StudentResponseDto.class);
	}

	private StudentResponseDto studentToStudentResponseDto(Student student) {
		StudentResponseDto dto = new StudentResponseDto();
		dto.setFirstName(student.getFirstName());
		dto.setLastName(student.getLastName());
		return dto;
	}

	@Override
	public Optional<Student> readStudentById(int studentId) {
		return studentRepo.findById(studentId);
	}

	@Override
	public List<Student> readStudentsByName(String firstName) {
		List<Student> students = studentRepo.findByFirstName(firstName);
		if (students.isEmpty()) {
			throw new StudentApiException("No students found with firstName: " + firstName);
		}
		return students;
	}
}
