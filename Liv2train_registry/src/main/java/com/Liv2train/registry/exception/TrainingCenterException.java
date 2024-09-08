package com.Liv2train.registry.exception;

public class TrainingCenterException extends RuntimeException {

	public TrainingCenterException(String message) {
        super(message);
    }

	public TrainingCenterException(String message, Throwable cause) {
		super(message, cause);
	}
}
