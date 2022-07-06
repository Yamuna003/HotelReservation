package com.edu.HotelReservation.Repository;

import java.time.LocalDateTime;
import java.time.Month;
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
	 LocalDateTime now = LocalDateTime.now();
	 
		LocalDateTime d = LocalDateTime.of(2022,Month.JULY,29,19,30,40);
		LocalDateTime d1 = LocalDateTime.of(2022, Month.JULY,31,19,30,40);
		Reservation reservation = reservationRepository.save(new Reservation (301,3,now,4,d,d1));
		Assertions.assertThat(reservation.getreservId()).isGreaterThan(0);
		
	}
	
	@Test
	public void getReservationTest()
	{
		Reservation reservation = reservationRepository.findById(102L).get();
		Assertions.assertThat(reservation.getreservId()).isEqualTo(102L);
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
		Reservation reservation = reservationRepository.findById(102L).get();
		reservation.setNoOfGuest(5);
		Reservation updated= reservationRepository.save(reservation);
		Assertions.assertThat(updated.getNoOfGuest()).isEqualTo(5);
		
	}
	
	@Test
	public void deleteReservationTest()
	{
		Reservation reservation = reservationRepository.findById(98L).get();
		reservationRepository.delete(reservation);
		Reservation reservations = null;
		Optional<Reservation> reservation1 = reservationRepository.findById(80L);
		if(reservation1.isPresent())
		{
			reservations = reservation1.get();
		}
		Assertions.assertThat(reservations).isNull();
	}
	
	
	

}
