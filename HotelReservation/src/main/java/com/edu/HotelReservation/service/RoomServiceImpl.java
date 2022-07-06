package com.edu.HotelReservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.NoRoomFoundFromGivenIdException;
import com.edu.HotelReservation.exception.RecordAlreadyExistException;
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
		
		List<Room> room1 = roomRepository.getRoomByRoomNo(room.getRoomNo());
		if(!room1.isEmpty())
		{
			throw new RecordAlreadyExistException();
			
		}
		else
		{
			return roomRepository.save(room);
		}
			
		
	}

	@Override
	public Optional<Room> getRoomById(long id) {
		Optional<Room> room =  roomRepository.findById(id);
		if(room.isPresent())
		{
			return room;
		}
		else
		{
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Room updateRoom(long id, Room room) {
	
		Room rooms = new Room();
		rooms = roomRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
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
		room = roomRepository.findById(id).orElseThrow( ()-> new NoRecordFoundException());
		roomRepository.deleteById(id);
		return "Record is deleted successfully";
	}

	@Override
	public List<Room> getRoomByRoomNo(String roomNo) {
		
		List <Room> room = roomRepository.getRoomByRoomNo(roomNo);
		if(room.isEmpty())
		{
			throw new NoRoomFoundFromGivenIdException();
		}
		else
		{
			return room;
		}
	}

	@Override
	public List<Room> getRoomByNoOfBed(String noOfBed) {
		
		List<Room> room = roomRepository.getRoomByNoOfBed(noOfBed);
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
	public List<Room> getRoomByStatus(boolean status) {
		
		return roomRepository.getRoomByStatus(status);
		
	}

	@Override
	public Map<Object, Object> getRoomGroupByStatus() {
		List<Object[]> objects = roomRepository.getRoomGroupByStatus();
		Map<Object,Object> map = new HashMap();
		for(Object[] obj :objects)
		{
			map.put(obj[0], obj[1]);
			
		}
		return map;
	}

	

	
	





	

}
