package com.capgemini.jst.SpringCapmates.advices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GameCollectionControllerAdvice extends ResponseEntityExceptionHandler{

	    @ExceptionHandler({ NullPointerException.class })
	    public ResponseEntity<Object> handleArithemticException(Exception ex, HttpServletRequest request) {
	        return ResponseEntity.badRequest().body("Processing error: " + request.getRequestURI());
	    }
	}


