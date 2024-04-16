package com.example.foodTownEntities.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice//it says this is the class which is going to handle all the exception globally.
public class GlobalException {
	// handling specific exception
			@ExceptionHandler(ResourceNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception,
					WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(new Date(), exception.getMessage(), 
								request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}

			
			// handling global exception
			
			@ExceptionHandler(Exception.class)
			public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
			}
}

