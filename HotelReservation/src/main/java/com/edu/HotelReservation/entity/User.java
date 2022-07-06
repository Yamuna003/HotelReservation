package com.edu.HotelReservation.entity;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="userTbl")
public class User {
	@Id
	@GeneratedValue( generator = "seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name ="seq" , initialValue=1)
	private long userId;
	@Column(nullable=false)
	//@NotNull
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	@Column(nullable = false)
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
	@Column(nullable = false)
	@NotBlank(message = "Contact Number is mandatory")
	@Digits( integer = 10, message = "Contact Number must be 10 digits", fraction = 0)
	private String contactNo;
	@Column(nullable = false)
	@NotBlank(message = "Adhar Number is mandatory")
	@Digits ( integer = 12 , message = "Aadhar number must be 12 digits", fraction = 0)
	private String adharNo;
	@Column(nullable = false)
	@NotBlank(message = "User Name is mandatory")
	private String userName;
	@Column(nullable = false)
	@NotBlank(message = "Password is mandatory")
	@Size(min=8, message = "The password must be equal to 8 letters or greater")
	private String password;
	@Column(nullable= false, unique = true)
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Invalid email id")
	private String emailId;
	@Column(nullable = false)
	@NotBlank(message = "Address is mandatory")
	private String address;
	
	
	@OneToMany(mappedBy="user")
	@JsonIgnoreProperties("user")
	private List<Reservation> reservation;
	
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	public User(long userId, @NotBlank(message = "First name is mandatory") String firstName,String lastName, String contactNo,String adharNo,String userName,
			      String emailId,String address,List<Reservation> reservation) {
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
	
	public User(long userId,  String firstName,String lastName, String contactNo,String adharNo, String userName,String password,
			 String emailId,String address) {
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
				+ ", emailId=" + emailId + ", address=" + address + ", profilePicture="
				 + ", reservation=" + reservation + "]";
	}
	
          
}
