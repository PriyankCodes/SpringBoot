package com.tss.jpa.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class ResponseError {

	private String message;
	private int status;
	private long timeStamp;
}
