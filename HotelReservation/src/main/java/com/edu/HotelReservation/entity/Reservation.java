
package com.edu.HotelReservation.entity;

import java.time.LocalDateTime;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservationTbl")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="seq", initialValue=201)
	private long reservId;
	private int noOfGuest;
	//@DateTimeFormat(pattern="yyyy-MM-dd hh:ss")
	private LocalDateTime reservationDateAndTime;
	private int stayDays;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime checkInDateTime;
	private LocalDateTime checkOutDateTime;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties("reservation")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roomId")
	@JsonIgnoreProperties("reservation")
	private Room room;
	
	@PrePersist
	public void addCheckInDate()
	{
		LocalDateTime now = LocalDateTime.now();
		this.reservationDateAndTime=now;
		this.checkOutDateTime = ((LocalDateTime) this.checkInDateTime).plusDays(stayDays);
		
	    
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Reservation(long reservId, int noOfGuest, LocalDateTime reservationDateAndTime, int stayDays,
			LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, User user, Room room) {
		super();
		this.reservId = reservId;
		this.noOfGuest = noOfGuest;
		this.reservationDateAndTime = reservationDateAndTime;
		this.stayDays = stayDays;
		this.checkInDateTime = checkInDateTime;
		this.checkOutDateTime = checkOutDateTime;
		this.user = user;
		this.room = room;
	}
	
	public long getreservId() {
		return reservId;
	}
	public void setreservId(long reservId) {
		this.reservId = reservId;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public LocalDateTime getReservationDateAndTime() {
		return reservationDateAndTime;
	}
    public void setReservationDateAndTime(LocalDateTime reservationDateAndTime) {
		this.reservationDateAndTime = reservationDateAndTime;
	}
	
	public int getStayDays() {
		return stayDays;
	}
	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}
	public LocalDateTime getCheckInDateTime() {
		return checkInDateTime;
	}
	public void setCheckInDateTime(LocalDateTime checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}
	public LocalDateTime getCheckOutDateTime() {
		return checkOutDateTime;
	}
	public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}
	
	public Reservation(long reservId, int noOfGuest, LocalDateTime reservationDateAndTime, int stayDays,
			LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
		super();
		this.reservId = reservId;
		this.noOfGuest = noOfGuest;
		this.reservationDateAndTime = reservationDateAndTime;
		this.stayDays = stayDays;
		this.checkInDateTime = checkInDateTime;
		this.checkOutDateTime = checkOutDateTime;
	}


	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reservation [reservId=" + reservId + ", noOfGuest=" + noOfGuest + ", reservationDateAndTime="
				+ reservationDateAndTime + ", stayDays=" + stayDays + ", checkInDateTime=" + checkInDateTime
				+ ", checkOutDateTime=" + checkOutDateTime + ", user=" + user + ", room=" + room + "]";
	}
	

}
