package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
