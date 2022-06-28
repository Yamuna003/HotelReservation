package com.edu.HotelReservation.service;

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

	

	

}
