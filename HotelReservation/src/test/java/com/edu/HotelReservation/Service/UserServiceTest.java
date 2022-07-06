package com.edu.HotelReservation.Service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.HotelReservation.repository.UserRepository;
import com.edu.HotelReservation.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	
	private UserServiceImpl userService;
	

	
	

}
