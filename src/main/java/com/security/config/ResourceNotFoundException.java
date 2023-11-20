package com.security.config;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
        super(message);
    }
}
