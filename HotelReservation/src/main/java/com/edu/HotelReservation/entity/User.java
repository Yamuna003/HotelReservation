package com.edu.HotelReservation.entity;

import java.util.List;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="userTbl")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	

  
	private String firstName;
	private String lastName;
	private String contactNo;
	private String adharNo;
	private String userName;
	private String password;
	private String emailId;
	private String address;
	
	@OneToMany(mappedBy="user")
	private List<Reservation> reservation;
	
	
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
	public User(long userId, String firstName, String lastName, String contactNo, String adharNo, String userName,
			String password, String emailId, String address, List<Reservation> reservation) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.adharNo = adharNo;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.address = address;
		this.reservation = reservation;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(long userId, String firstName, String lastName, String contactNo, String adharNo, String userName,
			String password, String emailId, String address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.adharNo = adharNo;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", adharNo=" + adharNo + ", userName=" + userName + ", password=" + password
				+ ", emailId=" + emailId + ", address=" + address + ", reservation=" + reservation + "]";
	}
	
          
}
