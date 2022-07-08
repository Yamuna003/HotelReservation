package com.edu.HotelReservation.Service;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.exception.RecordAlreadyExistException;
import com.edu.HotelReservation.repository.UserRepository;
import com.edu.HotelReservation.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@Autowired
	@InjectMocks
	private UserServiceImpl userService;
	
	private User user1;
	private User user2;
	List<User> userList;
	
	//Method to execute before each testcase execution
	//before each testcase
	@BeforeEach
	public void setUp() {
		userList = new ArrayList<>();
		
		user1 = new User(1,"yamuna","ramesh","9952722963","yamuna03@gmail.com");
		user2 = new User(2,"suriya","prabha","9384938495","suriyaprabha@gmail.com");
		userList.add(user1);
		userList.add(user2);
	}
	
	//Method to execute after each testcase execution
	@AfterEach
	public void afterTest()
	{
		user1 = user2 = null;
		userList=null;
	}
	
	//To test saveUser() method
 
	@DisplayName("Test for saveUser() method")
	@Test
	public void givenUserToAddShouldReturnAddedUser()
	{
		when(userRepository.save(user1)).thenReturn(user1);
		User savedUser = userService.saveUser(user1);
		System.out.println(savedUser);
		assertThat(savedUser).isNotNull();
	}
	
	@Test
	public void givenExistingIdWhenSaveUserThenThrowException()
	{
		User user = new User(1,"yamuna","ramesh","9952722963","yamuna03@gmail.com");
		when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		 Assertions.assertThrows(RecordAlreadyExistException.class, ()->userService.saveUser(user));
		
	}
	

	
	

}
