package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;



@Service
public class UserService {
	 @Autowired
	  UserRepo repo;
	

	    public void store(User std) {
	        repo.save(std);
	    }
	 
	    public List<User> getStudents() {

	        List<User> list=repo.findAll();    

	        return list;
	    }
	 
	    public User getStudent(int id) {

	    	User std=repo.findById(id).orElse(new User());

	        return std;
	    }
	 
	    public void deleteStd(int id) {
	        repo.deleteById(id);
	    }

		public User fetchstdbyemailandpass(String tempemail, String temppass) {
			
			return repo.findByEmailidAndPassword(tempemail, temppass);
		}


}

