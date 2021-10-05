package com.registration.login.app.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.registration.login.app.exceptions.AccountBlockedException;
import com.registration.login.app.exceptions.ExcessFailedTriesException;
import com.registration.login.app.exceptions.InvalidCredentialsException;
import com.registration.login.app.exceptions.InvalidUsernameException;
import com.registration.login.app.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class UserAccountExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {

		String errorMessage = "<h1 style=\"color:red; text-align:center;\">" + ex.getMessage() + "</h1>";

		return new ResponseEntity<String>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException ex) {

		String errorMessage = "<h1 style=\"color:red; text-align:center;\">" + ex.getMessage() + "</h1>";

		return new ResponseEntity<String>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidUsernameException.class)
	public ResponseEntity<String> handleInvalidUsernameException(InvalidUsernameException ex) {

		String errorMessage = "<h1 style=\"color:red; text-align:center;\">" + ex.getMessage() + "</h1>";

		return new ResponseEntity<String>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ExcessFailedTriesException.class)
	public ResponseEntity<String> handleExcessFailedTriesException(ExcessFailedTriesException ex) {

		String errorMessage = "<h1 style=\"color:red; text-align:center;\">" + ex.getMessage() + "</h1>";

		return new ResponseEntity<String>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AccountBlockedException.class)
	public ResponseEntity<String> handleAccountBlockedException(AccountBlockedException ex) {

		String errorMessage = "<h1 style=\"color:red; text-align:center;\">" + ex.getMessage() + "</h1>";

		return new ResponseEntity<String>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
