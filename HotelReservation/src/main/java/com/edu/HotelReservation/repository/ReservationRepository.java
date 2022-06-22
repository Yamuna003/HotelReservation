package com.edu.HotelReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.HotelReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
