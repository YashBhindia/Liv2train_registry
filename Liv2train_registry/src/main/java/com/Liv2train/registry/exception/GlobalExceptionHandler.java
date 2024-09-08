package com.Liv2train.registry.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorPayload> handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorPayload errorPayload = new ErrorPayload();
		errorPayload.setDescription(ex.getMessage());
		errorPayload.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorPayload.setMessage("Validation Error");
		errorPayload.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorPayload>(errorPayload, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorPayload> noHandlerFoundExceptionHandler(NoHandlerFoundException nfe) {

		ErrorPayload errorPayload = new ErrorPayload();
		errorPayload.setDescription(nfe.getMessage());
		errorPayload.setHttpStatus(HttpStatus.NOT_FOUND);
		errorPayload.setMessage("Please check the uri");
		errorPayload.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorPayload>(errorPayload, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorPayload> genericExceptionHandler(Exception e) {
		ErrorPayload errorPayload = new ErrorPayload();
		errorPayload.setDescription(e.getMessage());
		errorPayload.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errorPayload.setMessage("Internal server error");
		errorPayload.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorPayload>(errorPayload, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
