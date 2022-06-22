package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import com.edu.HotelReservation.entity.User;

public interface UserService {

	List<User> getUserList();

	User saveUser(User user);

	Optional<User> getUserById(long id);

	User updateUser(long id, User user);

	String deleteUser(long id);

	List<User> getUserByFirstName(String firstName);

	List<User> getUserByLastName(String lastName);

	List<User> getUserByFullName(String firstName, String lastName);

	List<User> getUserByEmail(String email);

}
