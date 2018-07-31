package com.capgemini.jst.SpringCapmates.advices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
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
				.withError_code(HttpStatus.NOT_FOUND.name()).withMessage(ex.getLocalizedMessage())
				.withDetail("occured at:" + request.getRequestURI()).build();

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {

		logger.error("Request: " + request.getRequestURL() + " raised " + ex);

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withError_code(HttpStatus.BAD_REQUEST.name()).withMessage(ex.getLocalizedMessage())
				.withDetail("occured at:" + request.getRequestURI()).build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	

	/*@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseBody
	public ResponseEntity<Object> handleMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex,
			HttpServletRequest request) {

		logger.error("Request: " + request.getRequestURL() + " raised " + ex);

		String unsupported = "Unsupported content type: " + ex.getContentType();
		String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withError_code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name()).withMessage(ex.getLocalizedMessage())
				.withDetail(supported + "/n" + "Provided Media Type: " + unsupported).build();

		return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpServletRequest request) {

		logger.error("Request: " + request.getRequestURL() + " raised " + ex);

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withError_code(HttpStatus.BAD_REQUEST.name()).withMessage("JSON parse error")
				.withDetail(ex.getMessage()).build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}*/

}
