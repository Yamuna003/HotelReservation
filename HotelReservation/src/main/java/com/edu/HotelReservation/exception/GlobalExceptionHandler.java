package com.edu.HotelReservation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	 
	 @ExceptionHandler (NoRoomFoundFromGivenIdException.class)
	 public ResponseEntity<Object> handleNoRoomFoundFromGivenIdException()
	 {
		 return new ResponseEntity<Object> ("No room found from given room no",HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler (RecordAlreadyExistException.class)
	 public ResponseEntity<Object> handleResourceAlreadyExistException()
	 {
		 return new ResponseEntity<Object> ("Resource is already exist",HttpStatus.FOUND);
	 }
	 
	 @ExceptionHandler (MethodArgumentNotValidException.class)
	 public  ResponseEntity<Map<String, String>> handleValidationExcpetions(MethodArgumentNotValidException ex)
	 {
		 Map<String, String> errors = new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach ((error) -> { 
			 String fieldName = ((FieldError) error).getField();
			 String errorMessage = error.getDefaultMessage();
			 errors.put(fieldName, errorMessage); });
		 return new ResponseEntity<Map<String, String>> (errors,HttpStatus.BAD_REQUEST);
			 
		 }
		 
	 }
	


