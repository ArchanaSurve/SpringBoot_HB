package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentDao {
	public Student saveStudent(Student student);
	public Student getStudentById(String studentId);
	public List<Student> getAllStudents();
	public boolean deleteStudentById(String studentId);
	public Student updateStudent(Student student);
}
