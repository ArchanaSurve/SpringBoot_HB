package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;
@Repository
public class StudentDao_impl implements StudentDao {
 
	@Autowired
	private SessionFactory sf;
	@Override
	public Student saveStudent(Student student) {
		Session session=sf.openSession();
		Transaction transaction =session.beginTransaction();
		try {
			session.save(student);
			transaction.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
		return student;
	}

	@Override
	public Student getStudentById(String studentId) {
		Session session=sf.openSession();
		Student student=null;
		try
		{
		
			student=session.get(Student.class, studentId);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
	
		Session session =sf.openSession();
		List<Student> list=null;
		try
		{
			Criteria criteria=session.createCriteria(Student.class);
			list=criteria.list();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public boolean deleteStudentById(String studentId) {
	
		Session session=sf.openSession();
		
		Transaction transaction=session.beginTransaction();
		boolean b=false;
		try
		{
			Student student=session.get(Student.class, studentId);
			if(student!=null)
			{
				session.delete(student);
				transaction.commit();
				b=true;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			b=false;
		}
		finally 
		{
			session.close();
		}
		return b;
	}

	@Override
	public Student updateStudent(Student student) {
Session session=sf.openSession();
	Transaction transaction=session.beginTransaction();
	try
	{
		session.update(student);
		transaction.commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	finally {
		session.close();
	}
	return student;
	}
	
}
