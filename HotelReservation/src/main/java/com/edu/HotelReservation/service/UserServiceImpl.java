package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NameNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.ResourceNotFoundException;
import com.edu.HotelReservation.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUserList() {
		
		List<User> user= userRepository.findAll();
		if(user.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return user;
		}
	
		
	}

	@Override                                       
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(long id) {
		Optional<User> user = (userRepository.findById(id)); 
		
		if(user.isPresent())
		{
			return user;
		}
		else
		{
			throw new GivenIdNotFoundException();
		}
		
	}

	@Override
	public User updateUser(long id, User user) {
		User users = new User();
		users = userRepository.findById(id).orElseThrow( ()-> new NoRecordFoundException());
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setContactNo(user.getContactNo());
		users.setAdharNo(user.getAdharNo());
		users.setUserName(user.getUserName());
		users.setPassword(user.getPassword());
		users.setEmailId(user.getEmailId());
	    users.setAddress(user.getAddress());
	    
	    userRepository.save(users);
		
		return users ;
	}

	@Override
	public String deleteUser(long id) {
		User user = new User();
		user = userRepository.findById(id).orElseThrow( ()-> new NoRecordFoundException());
		userRepository.deleteById(id);
		
		return "Record is deleted successfully";
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		
	List<User> user = userRepository.getByFirstName(firstName);
	if(user.isEmpty())
	{
		throw new NameNotFoundException();
	}
	else
	{
		return user;
	}
		
		
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		
		List<User> user = userRepository.getUserByLastName(lastName);
		if(user.isEmpty())
		{
			throw new NameNotFoundException();
			
		}
		else
		{
			return user;
		}
	}

	@Override
	public List<User> getUserByFullName(String firstName, String lastName) {
		
		List<User> user = userRepository.getUserByFullName(firstName,lastName);
		if(user.isEmpty())
		{
			throw new NameNotFoundException();
		}
		else
		{
			return user;
		}
	}

	@Override
	public Optional<User> getUserByEmail(String emailId) {
		
		Optional<User> user = userRepository.findByEmailId(emailId);
		if(user.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return user;
		}
	}
	
	

	

	
    
	

	
	}


