package com.edu.HotelReservation.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.HotelReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query ("select r from Reservation r where r.reservationDateAndTime= :reservationDateAndTime")
	List<Reservation> getReservationListByDate(@Param ("reservationDateAndTime")LocalDateTime reservationDateAndTime);

	@Query ("select r from Reservation r where r.checkInDateTime= :checkInDateTime")
	List<Reservation> getReversationListByCheckInDate(@Param ("checkInDateTime") LocalDateTime checkInDateTime);

	@Query ("select r from Reservation r where checkInDateTime between :checkInDateTime and :checkOutDateTime")
	List<Reservation> getReservationListByGivenRange(@Param ("checkInDateTime") LocalDateTime checkInDateTime,@Param("checkOutDateTime") LocalDateTime checkOutDateTime);

	@Query ("select r from Reservation r where user.userId= :userId")
	List<Reservation> getReservationByUserId(@Param ("userId") long userId);

	


	
	

	
	
}
