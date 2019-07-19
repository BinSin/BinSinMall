package kr.ac.binsin.constroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.ac.binsin.exception.ErrorResponse;
import kr.ac.binsin.exception.UserDuplicatedException;
import kr.ac.binsin.exception.UserNotFoundException;

@ControllerAdvice // Controller + Exception
public class GlobalExceptionController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		String requestURL = req.getRequestURL().toString();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.notfound.exception");
		errorResponse.setErrorMsg("User with id " + ex.getUserId() + " not found");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	
	}

	@ExceptionHandler(UserDuplicatedException.class)
	public ResponseEntity<ErrorResponse> handleUUserDuplicatedException(HttpServletRequest req, UserDuplicatedException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		String requestURL = req.getRequestURL().toString();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.duplicated.exception");
		errorResponse.setErrorMsg("Unable to create. A user with name " + ex.getUserName() + " already exist");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	
	}
	
}
