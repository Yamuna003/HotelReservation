package com.edu.HotelReservation.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.HotelReservation.entity.User;
import com.edu.HotelReservation.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	/*@Test
	public void saveUserTest()
	{
		
		User user = userRepository.save(new User(39,"rama","prabha","9500732378","3395839573","rama","palani@12","ramaprabha@gmail.com","36,c LIC Colony"));
		
		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
	}
	*/
	 
	@Test
	public void getUserTest()
	{
		User user = userRepository.findById(40L).get();
		Assertions.assertThat(user.getUserId()).isEqualTo(40L);
		
	}
	 @Test
	 public void getUserListTest()
	 {
		 List<User> user = userRepository.findAll();
		 Assertions.assertThat(user.size()).isGreaterThan(0);
	 }
	
	 @Test
	 public void updatedUserTest()
	 {
		 User user = userRepository.findById(40L).get();
		  user.setEmailId("rama@gmail.com");
		   User updated = userRepository.save(user);
		   
		   Assertions.assertThat(updated.getEmailId()).isEqualTo("rama@gmail.com");
	 }
	
	
    @Test
	public void deleteUserTest()
	{
		User user = userRepository.findById(59L).get();
		userRepository.delete(user);
		User users = null;
		Optional<User> user1 = userRepository.findByEmailId("ramaprabha@gmail.com");
		if(user1.isPresent())
		{
			users = user1.get();
		}
		Assertions.assertThat(users).isNull();
	}
	
	@Test
	public void getUserByFirstNameTest()
	{
		List<User> user = userRepository.getByFirstName("rama");
		Assertions.assertThat(user);
	}
	
	@Test
	public void getUserByLastNameTest()
	{
		List<User> user = userRepository.getUserByLastName("ramesh");
		Assertions.assertThat(user);
	}
	
	@Test
	public void getUserByFullNameTest()
	{
		List<User> user = userRepository.getUserByFullName("gowri", "ravi");
		Assertions.assertThat(user);
	}
	
	@Test
	public void getUserByEmail()
	{
	    Optional<User> user = userRepository.findByEmailId("yamuna.r0311@gmail.com");
	    Assertions.assertThat(user);
	}
	 

}
