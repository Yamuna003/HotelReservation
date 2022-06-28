package com.edu.HotelReservation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.HotelReservation.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

	
	@Query ("select u from User u where u.firstName= :firstName")
	List<User> getByFirstName(@Param ("firstName") String firstName);
    
	
	@Query ("select u from User u where u.lastName= :lastName")
	List<User> getUserByLastName(@Param ("lastName") String lastName);

   @Query ("select u from User u where u.firstName= :firstName and u.lastName= :lastName")
	List<User> getUserByFullName(String firstName, String lastName);


           Optional<User> findByEmailId(String emailId);


        

         


    


             

         
	
	

}
