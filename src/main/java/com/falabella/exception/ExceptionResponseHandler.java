package com.falabella.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {

		return createResponseEntity(ex.getMessage(), request.getDescription(false));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String message = ex.getBindingResult().getAllErrors().stream().map(e -> {
			return e.getDefaultMessage().concat(", ");
		}).collect(Collectors.joining());

		return createResponseEntity(message, request.getDescription(false));
	}

	private ResponseEntity<Object> createResponseEntity(String message, String description) {

		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), message, description);

		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
