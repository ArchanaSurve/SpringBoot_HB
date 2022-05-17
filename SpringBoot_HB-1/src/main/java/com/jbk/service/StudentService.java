package com.jbk.service;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public Student getStudentById(String studentId);
	public List<Student> getAllStudents();
	public boolean deleteStudentById(String studentId);
	public Student updateStudent(Student student);
}
