package com.edu.HotelReservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.HotelReservation.entity.Room;

public interface RoomRepository extends JpaRepository <Room, Long> {

	
	@Query ("select r from Room r where r.roomNo= :roomNo")
	List<Room> getRoomByRoomNo(@Param ("roomNo") String roomNo);

	@Query ("select r from Room r where r.noOfBed= :noOfBed")
	List<Room> getRoomByNoOfBed(@Param ("noOfBed") String noOfBed);

	@Query ("select r from Room r where r.status= :status")
	List<Room> getRoomByStatus(@Param ("status") boolean status);

}
