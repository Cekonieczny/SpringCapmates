package com.capgemini.jst.SpringCapmates.advices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.jst.SpringCapmates.exceptions.NoSuchElementInDatabaseException;

@ControllerAdvice
public class GameCollectionControllerAdvice extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler({ NoSuchElementInDatabaseException.class })
	public ResponseEntity<Object> handleNoSuchElementInDatabaseException(NoSuchElementInDatabaseException ex, HttpServletRequest request) {

		logger.error("Request: " + request.getRequestURL() + " raised " + ex);

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withError_code(HttpStatus.NOT_FOUND.getReasonPhrase()).withMessage(ex.getLocalizedMessage())
				.withDetail("occured at:" + request.getRequestURI()).build();

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {

		logger.error("Request: " + request.getRequestURL() + " raised " + ex);

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withError_code(HttpStatus.BAD_REQUEST.getReasonPhrase()).withMessage(ex.getLocalizedMessage())
				.withDetail("occured at:" + request.getRequestURI()).build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
