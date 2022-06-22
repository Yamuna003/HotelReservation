package com.edu.HotelReservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	    
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<Object> handleNoRecordFoundException()
	{
		return new ResponseEntity<Object> ("No Record Found!",HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler (GivenIdNotFoundException.class)
     public ResponseEntity<Object> handleGivenIdNotFoundException()
     {
    	 return new ResponseEntity<Object> ("Given Id is not avaiable!",HttpStatus.NOT_FOUND);
     }
	 
	 @ExceptionHandler (NameNotFoundException.class)
	 public ResponseEntity<Object> handleGivenNameNotFoundException()
	 {
		 return new ResponseEntity<Object> ("Given Name is not avaiable!",HttpStatus.NOT_FOUND);
	 }

}
