package com.edu.HotelReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;

	@GetMapping
	public List<Room> getRoomList()
	{
		return roomService.getRoomList();
	}
    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room)
    {
    	return new ResponseEntity<Room> (roomService.saveRoom(room),HttpStatus.CREATED);
    }
    @GetMapping ("/{id}")
    public Room getRoomById(@PathVariable ("id") long id)
    {
    	return roomService.getRoomById(id);
    }
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable ("id") long id, @RequestBody Room room)
    {
    	return roomService.updateRoom(id,room);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable ("id") long id)
    {
    	return new ResponseEntity<String> (roomService.deleteRoom(id),HttpStatus.OK);
    }
    @GetMapping("/getRoomByRoomNo/{roomNo}")
    public Room getRoomByRoomNo(@PathVariable ("roomNo") String roomNo)
    {
    	return roomService.getRoomByRoomNo(roomNo);
    }
    @GetMapping("/getRoomByNoOfBed/{noOfBed}")
    public List<Room> getRoomByNoOfBed(@PathVariable ("noOfBed") String noOfBed)
    {
    	return roomService.getRoomByNoOfBed(noOfBed);
    }
    @GetMapping("/getRoomByStatus/{status}")
    public List<Room> getRoomByStatus(@PathVariable ("status") boolean status)
    {
    	return roomService.getRoomByStatus(status);
    }
}
