package com.tss.jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentApiException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}
}
