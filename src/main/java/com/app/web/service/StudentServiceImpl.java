package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.student;
import com.app.web.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<student> listAllStudents(){
		return repository.findAll();
	}

	@Override
	public student saveStudent(student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public student updateStudent(student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}
