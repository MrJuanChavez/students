package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entity.student;
import com.app.web.repository.StudentRepository;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public void run(String... args) throws Exception{
		/*student student1 = new student("Juan","Ramirez","jmchd015@gmail.com");
		repository.save(student1);

		student student2 = new student("Carlos","Perez","carlos.p9090@gmail.com");
		repository.save(student2);
		*/
	}

}
