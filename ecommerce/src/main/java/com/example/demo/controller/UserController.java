package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;




@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class UserController {
	
	@Autowired
	UserService service;

    @PostMapping( value = "/saveCustomers" ,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<User> print(@RequestBody User std)
    {   
        service.store(std);
        return new ResponseEntity<User>(std,HttpStatus.CREATED);
    }
    



    @GetMapping( value = "/Customers" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<User>> getStds()
    {   
        List<User> list=service.getStudents();
        return new ResponseEntity<List<User>>(list,HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public User loginuser(@RequestBody User std) throws Exception
    {
    String tempemail=std.getEmailid();
    String temppass=std.getPassword();
    User obj=null;
    if(tempemail !=null && temppass!=null) {
    obj=service.fetchstdbyemailandpass(tempemail, temppass);

    }
    if(obj ==null)
    {
    throw new Exception("User doesnot exits");
    }
    return obj;

    }

    @GetMapping( value = "/Customer/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
   public ResponseEntity<User> getStd(@PathVariable("id") int id)
    {   
    	User std=service.getStudent(id);
        return new ResponseEntity<User>(std,HttpStatus.CREATED);
    }
    
    
    

    @PutMapping( value = "/Customer" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateStd(@RequestBody User std)
    {   
        service.store(std);
        return new ResponseEntity<User>(std,HttpStatus.CREATED);
    }
    

    @DeleteMapping( value = "/delete/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id)
    {   
        service.deleteStd(id);
        return new ResponseEntity<String>("recored deleted",HttpStatus.CREATED);
    }

}

