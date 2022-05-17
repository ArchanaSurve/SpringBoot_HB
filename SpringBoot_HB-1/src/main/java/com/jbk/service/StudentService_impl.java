package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDao;
import com.jbk.entity.Student;
@Service
public class StudentService_impl implements StudentService {
  
	@Autowired StudentDao dao;
	@Override
	public Student saveStudent(Student student) {
		String studendId=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		student.setStudentId(studendId);
		Student std=dao.saveStudent(student);
		return std;
	}

	@Override
	public Student getStudentById(String studentId) {
		Student student=dao.getStudentById(studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
	List<Student> list=dao.getAllStudents();
		return list;
	}

	@Override
	public boolean deleteStudentById(String studentId) {
	    boolean b=dao.deleteStudentById(studentId);
		return b;
	}

	@Override
	public Student updateStudent(Student student) {
	Student std=dao.updateStudent(student);
		return std;
	}

}
