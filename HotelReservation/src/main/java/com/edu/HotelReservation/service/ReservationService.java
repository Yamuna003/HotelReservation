package com.edu.HotelReservation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.edu.HotelReservation.entity.Reservation;



public interface ReservationService {

	List<Reservation> getReservationList();

	Reservation saveRservation(Reservation reservation);

	Optional<Reservation> getReservationById(long id);

	Reservation updateReservation(long id, Reservation reservation);

	String deleteReservation(long id);

	List<Reservation> getReservationListByDate(LocalDateTime reservationDateAndTime);

	List<Reservation> getReservationListByCheckInDate(LocalDateTime checkInDateTime);

	List<Reservation> getReservationListByGivenRange(LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime);

	

	

	

}
