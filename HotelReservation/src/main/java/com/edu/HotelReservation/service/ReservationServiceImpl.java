package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.ResourceNotFoundException;
import com.edu.HotelReservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	@Override
	public List<Reservation> getReservationList() {
		
		List<Reservation> reservation =  reservationRepository.findAll();
		if(reservation.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return reservation;
		}
	}

	@Override
	public Reservation saveRservation(Reservation reservation) {
		
		return reservationRepository.save(reservation);
	}

	@Override
	public Optional<Reservation> getReservationById(long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if(reservation.isPresent())
		{
			return reservation;
		}
		else
		{
			throw new GivenIdNotFoundException();
		}
		
	}

	@Override
	public Reservation updateReservation(long id, Reservation reservation) {
		Reservation reservations = new Reservation();
		reservations = reservationRepository.findById(id).orElseThrow ( ()-> new NoRecordFoundException());
		reservations.setStayDays(reservation.getStayDays());
		reservations.setNoOfGuest(reservation.getNoOfGuest());
		reservations.setCheckInDateTime(reservation.getCheckInDateTime());
		reservations.setCheckOutDateTime(reservation.getCheckOutDateTime());
		reservationRepository.save(reservations);
		return reservations;
	}

	@Override
	public String deleteReservation(long id) {
	     Reservation reservation = new Reservation();
	     reservation = reservationRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
	     reservationRepository.deleteById(id);
		return "Record is deleted successfully";
	}

	

	
	

	
}
