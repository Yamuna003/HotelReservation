package com.edu.HotelReservation.service;

import java.util.List;

import com.edu.HotelReservation.entity.Room;

public interface RoomService {

	List<Room> getRoomList();

	Room saveRoom(Room room);

	Room getRoomById(long id);

	Room updateRoom(long id, Room room);

	String deleteRoom(long id);

	Room getRoomByRoomNo(String roomNo);

	List<Room> getRoomByNoOfBed(String noOfBed);

	List<Room> getRoomByStatus(boolean status);

	
	

	

}
