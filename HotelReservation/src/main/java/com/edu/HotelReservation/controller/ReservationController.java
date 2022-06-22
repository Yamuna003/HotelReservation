package com.edu.HotelReservation.controller;

import java.util.List;

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

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping
	public List<Reservation> getReservationList()
	{
		return reservationService.getReservationList();
	}
	
	@PostMapping
	public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation)
	{
		return new ResponseEntity<Reservation> (reservationService.saveRservation(reservation),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable ("id") long id)
	{
		return reservationService.getReservationById(id);
	}
	@PutMapping("/{id}")
	public Reservation updateReservation(@PathVariable ("id") long id,@RequestBody Reservation reservation)
	{
		return reservationService.updateReservation(id,reservation);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable ("id") long id)
	{
		return new ResponseEntity<String> (reservationService.deleteReservation(id),HttpStatus.OK);
	}

}
