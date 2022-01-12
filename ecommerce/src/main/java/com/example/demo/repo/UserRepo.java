package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
	public User findByEmailidAndPassword(String tempemail,String temppass);

}
