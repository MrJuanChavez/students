package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entity.student;
import com.app.web.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping({"/students", "/"})
	public String listStudents(Model model) {
		model.addAttribute("students", service.listAllStudents());
		return "students"; //sends us to the file "students"
	}
	
	@GetMapping("/students/new")
		public String createStudentForm(Model model) {
		student student = new student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", service.getStudentById(id));
	return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") student student, Model model) {
		student registeredStudent =service.getStudentById(id);
		registeredStudent.setId(id);
		registeredStudent.setName(student.getName());
		registeredStudent.setLastname(student.getLastname());
		registeredStudent.setEmail(student.getEmail());
		
		service.updateStudent(registeredStudent);
		return "redirect:/students";		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}

}
