package com.edu.HotelReservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.ResourceNotFoundException;
import com.edu.HotelReservation.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomRepository roomRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public List<Room> getRoomList() {
		
		List<Room> room = roomRepository.findAll();
		if(room.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return room;
		}
	}

	@Override
	public Room saveRoom(Room room) {
		
		return roomRepository.save(room) ;
	}

	@Override
	public Room getRoomById(long id) {
		Room room = new Room();
		room = roomRepository.findById(id).orElseThrow ( ()-> new ResourceNotFoundException ("Room", "id",id));
		return room;
	}

	@Override
	public Room updateRoom(long id, Room room) {
	
		Room rooms = new Room();
		rooms = roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room", "id",id));
		rooms.setRoomNo(room.getRoomNo());
		rooms.setNoOfBed(room.getNoOfBed());
		rooms.setRoomFare(room.getRoomFare());
		rooms.setStatus(room.isStatus());
		roomRepository.save(rooms);
		return rooms;
	}

	@Override
	public String deleteRoom(long id) {
		Room room = new Room();
		room = roomRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Room","id",id));
		roomRepository.deleteById(id);
		return "Record is deleted successfully";
	}

	@Override
	public Room getRoomByRoomNo(String roomNo) {
		
		return roomRepository.getRoomByRoomNo(roomNo);
	}

	@Override
	public List<Room> getRoomByNoOfBed(String noOfBed) {
		
		return roomRepository.getRoomByNoOfBed(noOfBed);
	}

	@Override
	public List<Room> getRoomByStatus(boolean status) {
		
		return roomRepository.getRoomByStatus(status);
	}

	
	





	

}
