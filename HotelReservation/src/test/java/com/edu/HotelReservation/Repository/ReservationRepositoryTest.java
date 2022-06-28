package com.edu.HotelReservation.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.HotelReservation.entity.Reservation;
import com.edu.HotelReservation.repository.ReservationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ReservationRepositoryTest {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Test
	public void saveReservationTest()
	{
		Date d1 = new Date(2022,04,03);
		Date d2 = new Date(2022,04,06);
		
		Reservation reservation = reservationRepository.save(new Reservation (301,3,3,d1,d2));
		Assertions.assertThat(reservation.getreservId()).isGreaterThan(0);
		
	}
	
	@Test
	public void getReservationTest()
	{
		Reservation reservation = reservationRepository.findById(68L).get();
		Assertions.assertThat(reservation.getreservId()).isEqualTo(68L);
	}
	
	@Test
	public void getReservationListTest()
	{
		List<Reservation> reservation = reservationRepository.findAll();
		Assertions.assertThat(reservation.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateReservationTest()
	{
		Reservation reservation = reservationRepository.findById(68L).get();
		reservation.setNoOfGuest(5);
		Reservation updated= reservationRepository.save(reservation);
		Assertions.assertThat(updated.getNoOfGuest()).isEqualTo(5);
		
	}
	
	@Test
	public void deleteReservationTest()
	{
		Reservation reservation = reservationRepository.findById(20L).get();
		reservationRepository.delete(reservation);
		Reservation reservations = null;
		Optional<Reservation> reservation1 = reservationRepository.findById(20L);
		if(reservation1.isPresent())
		{
			reservations = reservation1.get();
		}
		Assertions.assertThat(reservations).isNull();
	}
	
	
	

}
