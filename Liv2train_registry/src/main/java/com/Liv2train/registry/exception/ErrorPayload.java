package com.Liv2train.registry.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorPayload {

	private LocalDateTime timestamp;
	private HttpStatus httpStatus;
	private String message;
	private String description;
	
	

}
