package com.edu.HotelReservation.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.HotelReservation.entity.Room;
import com.edu.HotelReservation.repository.RoomRepository;





@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoomRepositoryTest {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void saveRoomTest() {
		Room room = roomRepository.save(new Room(201,"201","3",2500.35,true));		
		Assertions.assertThat(room.getRoomId()).isGreaterThan(0);
	}
	
	
	@Test
	public void getRoomTest()
	{
		Room room = roomRepository.findById(152L).get();
		Assertions.assertThat(room.getRoomId()).isEqualTo(152L);
				
	}
	
	@Test
	public void getRoomListTest()
	{
		List<Room> room = roomRepository.findAll();
		Assertions.assertThat(room.size()).isGreaterThan(0);
		
	}
	
	@Test
	public void updateRoomTest()
	{
		Room room = roomRepository.findById(52L).get();
	    room.setNoOfBed("7");
	    Room updated = roomRepository.save(room);
	    
	    Assertions.assertThat(updated.getNoOfBed()).isEqualTo("7");
	
	}
	
	@Test
	public void deleteRoomTest()
	{
		Room room = roomRepository.findById(48L).get();
		roomRepository.delete(room);
		Room rooms = null;
        Optional<Room> room1 = roomRepository.findById(48L);
        if(room1.isPresent())
        {
        	rooms = room1.get();
        }
        Assertions.assertThat(rooms).isNull();
	}
	
	@Test
	public void getRoomByRoomNoTest()
	{
		List<Room> room = roomRepository.getRoomByRoomNo("101");
		Assertions.assertThat(room);
	}
	
	@Test
	public void getRoomByNoOfBedTest()
	{
		List<Room> room = roomRepository.getRoomByNoOfBed("3");
		Assertions.assertThat(room);
	}
	
	@Test
	public void getRoomByStatus()
	{
		List<Room> room = roomRepository.getRoomByStatus(true);
		Assertions.assertThat(room);
	}

}
