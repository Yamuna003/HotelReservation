package com.edu.HotelReservation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.RecordAlreadyExistException;
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
		
		Optional<Reservation> reservations = reservationRepository.findById(reservation.getreservId());
		if(!reservations.isPresent())
		{
			return reservationRepository.save(reservation);
		}
		else
		{
			throw new RecordAlreadyExistException();
		}
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
		reservations.setCheckOutDateTime(reservation.getCheckInDateTime().plusDays(reservation.getStayDays()));
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


	@Override
	public List<Reservation> getReservationListByDate(LocalDateTime reservationDateAndTime) {
		
	//	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Reservation> reservation = reservationRepository.getReservationListByDate(reservationDateAndTime);
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
	public List<Reservation> getReservationListByCheckInDate(LocalDateTime checkInDateTime) {
		List<Reservation> reservation = reservationRepository.getReversationListByCheckInDate(checkInDateTime);
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
	public List<Reservation> getReservationListByGivenRange(LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
		List<Reservation> reservation = reservationRepository.getReservationListByGivenRange(checkInDateTime,checkOutDateTime);
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
	public List<Reservation> getReservationByUserId(long userId) {
	List<Reservation> reservations = reservationRepository.getReservationByUserId(userId);
	if(reservations.isEmpty())
	{
		throw new NoRecordFoundException();
	}
	else
	{
		return reservations;
	}
	}

	

	

	
	

	
}
