package com.tss.hibernate.dao;

import java.util.List;

import com.tss.hibernate.entity.Student;

public interface StudentDao {

	Student addNewStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getStudentById(int studentId);
	
	Student getStudentByRollNumber(int rollNumber);

    List<Student> getStudentsByName(String name);
}
