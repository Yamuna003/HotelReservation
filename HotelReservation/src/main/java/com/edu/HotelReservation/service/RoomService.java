package com.edu.HotelReservation.service;

import java.util.List;
import java.util.Optional;

import com.edu.HotelReservation.entity.Room;

public interface RoomService {

	List<Room> getRoomList();

	Room saveRoom(Room room);

	Optional<Room> getRoomById(long id);

	Room updateRoom(long id, Room room);

	String deleteRoom(long id);

	List<Room> getRoomByRoomNo(String roomNo);

	List<Room> getRoomByNoOfBed(String noOfBed);

	List<Room> getRoomByStatus(boolean status);

	
	

	

}
