package com.falabella.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private LocalDateTime exceptionDate;
	private String message;
	private String details;

	public ExceptionResponse() {
	}

	public ExceptionResponse(LocalDateTime exceptionDate, String message, String details) {
		this.exceptionDate = exceptionDate;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getExceptionDate() {
		return exceptionDate;
	}

	public void setExceptionDate(LocalDateTime exceptionDate) {
		this.exceptionDate = exceptionDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
