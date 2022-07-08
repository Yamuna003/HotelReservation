package com.edu.HotelReservation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUserList()
	{
		return userService.getUserList();
	}
	@PostMapping
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User> (userService.saveUser(user),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id)
	{
		return userService.getUserById(id);
	}
	@PutMapping("/{id}")
	public User updateUser(@PathVariable ("id") long id,@Valid @RequestBody User user)
	{
		return userService.updateUser(id,user);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable ("id") long id)
	{
		return new ResponseEntity<String> (userService.deleteUser(id),HttpStatus.OK);
		
	}
	@GetMapping("/firstName/{firstName}")
	public List<User> getUserByFirstName(@PathVariable ("firstName") String firstName)
	{
		return userService.getUserByFirstName(firstName);
	}
	
	@GetMapping("/lastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable ("lastName") String lastName)
	{
		return userService.getUserByLastName(lastName);
	}
	
	@GetMapping("/GetUserByFullName/{firstName}/{lastName}")
	public List<User> getUserByFullName(@PathVariable ("firstName") String firstName, @PathVariable ("lastName") String lastName)
	{
		return userService.getUserByFullName(firstName,lastName);
	}
	 
	@GetMapping("/GetUserByEmail/{emailId}")
	public Optional<User> getUserbyEmail(@PathVariable ("emailId") String emailId)
	{
		return userService.getUserByEmail(emailId);
	}
	
	
	
}
