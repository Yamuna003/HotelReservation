package com.edu.HotelReservation.Service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.exception.GivenIdNotFoundException;
import com.edu.HotelReservation.exception.NoRecordFoundException;
import com.edu.HotelReservation.exception.RecordAlreadyExistException;
import com.edu.HotelReservation.repository.RoomRepository;
import com.edu.HotelReservation.service.RoomServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {
	
	@Mock
	private RoomRepository roomRepository;
	
	@Autowired
	@InjectMocks
	private RoomServiceImpl roomService;
	
	private Room room1;
	private Room room2;
	private Room room3;
	List<Room> roomList;

	
	
	//Method to execute before each testcase execution
   // before each testcase
	
	@BeforeEach
	public void setUp()
	{
		roomList = new ArrayList<>();
		room1 = new Room(105,"1008","3",1800,true);
		room2 = new Room(106,"1009","4",2000,true);
		roomList.add(room1);
		roomList.add(room2);
	}
	
	//method to execute after each testcase execution
	
	@AfterEach
	public void afterTest()
	{
		room1=room2=null;
		roomList=null;
	}
	
	//To test saveRoom() method
	@DisplayName("Test for saveRoom() method")
	@Test
	public void givenRoomToAddShouldReturnAddedRoom()
	{
		when(roomRepository.save(room1)).thenReturn(room1);
		
		//when - behavior that we are going test
		
		Room savedRoom = roomService.saveRoom(room1);
		System.out.println(savedRoom);
		assertThat(savedRoom).isNotNull();
		
	}
	//To test saveRoom() method throws exception if given Record is already exist
	
	@Test
	public void givenExistingRoomNoWhenSaveEmployeeThenThrowsException()
	{
		Room room = new Room(105,"1008","3",1800,true);
		when(roomRepository.getRoomByRoomNo(room.getRoomNo()))
		               .thenReturn(List.of(room));
		  Assertions.assertThrows(RecordAlreadyExistException.class, ()->roomService.saveRoom(room));
		
	}

	//To test getRoomList() method
    @Test
	public void givenGetAllRoomShouldReturnListOfAllRoom() throws NoRecordFoundException {
		roomRepository.saveAll(roomList);
		when(roomRepository.findAll()).thenReturn(roomList);
		List<Room> actualRoomList = roomService.getRoomList();
		assertThat(actualRoomList).isEqualTo(roomList);
		}
    
  /* @Test
    public void givenRoomIdThenShouldReturnRoomOfThatRoomId() throws GivenIdNotFoundException{
    	when(roomRepository.findById(105L)).thenReturn(Optional.ofNullable(room1));
        assertThat(roomService.getRoomById(room1.getRoomId())).isEqualTo(room1);
    }*/
	
    @Test
    public void givenIdToDeleteShouldDeleteRoomOfThatId()
    {
    	when(roomRepository.findById(room1.getRoomId())).thenReturn(Optional.ofNullable(room1));
    	assertThat(roomService.deleteRoom(room1.getRoomId())).isEqualTo("Record is deleted successfully");
    }
    @Test
    public void givenIdDeleteNotExistThenThrowsException()
    {
    	long roomId=1L;
    	Assertions.assertThrows(NoRecordFoundException.class, ()-> roomService.deleteRoom(roomId));
    }
    
    @Test
    public void givenRoomObject_whenUpdateRoom_thenReturnUpdateRoom()
    {
    	long id=105L;
    	when(roomRepository.save(room1)).thenReturn(room1);
    	when(roomRepository.findById(id)).thenReturn(Optional.of(room1));
    	room1.setNoOfBed("6");
    	room1.setRoomFare(3000);
    	Room updatedRoom = roomService.updateRoom(id, room1);
    	assertThat(updatedRoom.getNoOfBed()).isEqualTo("6");
    	assertThat(updatedRoom.getRoomFare()).isEqualTo(3000);
    }
    @Test
    public void givenIdToUpdateNotExistThenThrowsException()
    {
    	long RoomId=1L;
    	Room room = new Room();
    	room1.setNoOfBed("1");
    	room1.setRoomFare(500);
    	Assertions.assertThrows(NoRecordFoundException.class,()-> {roomService.updateRoom(RoomId, room);});
    }
    
	
	

}
