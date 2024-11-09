package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entity.student;

@Repository
public interface StudentRepository extends JpaRepository<student, Long>{

}
