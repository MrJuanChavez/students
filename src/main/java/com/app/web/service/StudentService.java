package com.app.web.service;

import java.util.List;

import com.app.web.entity.student;

public interface StudentService {

	public List<student> listAllStudents();
	
	public student saveStudent(student student);
	
	public student getStudentById(Long id);
	
	public student updateStudent(student student);
	
	public void deleteStudent(Long id);
}
