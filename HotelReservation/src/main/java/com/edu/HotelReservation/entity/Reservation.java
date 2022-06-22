package com.edu.HotelReservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservationTbl")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reservId;
	private int noOfGuest;
	private int stayDays;
	private Date checkInDateTime;
	private Date checkOutDateTime;
	public long getReservId() {
		return reservId;
	}
	public void setReservId(long reservId) {
		this.reservId = reservId;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public int getStayDays() {
		return stayDays;
	}
	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}
	public Date getCheckInDateTime() {
		return checkInDateTime;
	}
	public void setCheckInDateTime(Date checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}
	public Date getCheckOutDateTime() {
		return checkOutDateTime;
	}
	public void setCheckOutDateTime(Date checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}
	public Reservation(long reservId, int noOfGuest, int stayDays, Date checkInDateTime, Date checkOutDateTime) {
		super();
		this.reservId = reservId;
		this.noOfGuest = noOfGuest;
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
		return "Reservation [reservId=" + reservId + ", noOfGuest=" + noOfGuest + ", stayDays=" + stayDays
				+ ", checkInDateTime=" + checkInDateTime + ", checkOutDateTime=" + checkOutDateTime + "]";
	}
	

}
