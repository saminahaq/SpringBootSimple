package com.SpringBootExample.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SpringBootExample.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*
	 * so this class handle all of the exception that we need to send back as a response,
	 * instead of getting generic message it will handle and send the specified message 
	 * 
	 * and it wil extended by "ResponseEntityExceptionHandler"
	 * 
	 * also, it annotated by @ControllerAdvice : its handling all exception of the application
	 * @controllerAdvice : it include all the controller that we have in the packages for the application
	 * 
	 * as we are sending the response so we need this annotation @ResponseStatus 
	 * 
	 * now, so far we created only one DepartmentNotFoundException, so now we need to create the method
	 * that handle DepartmentNotFoundException exception whenever it occures and through that method we send as a
	 * custom response. so for that we need POJO for error message
	 * 
	 * so first, we create a class of the error message [POJO], and than create a method here 
	 * so now the method here departmentNotFoundException() is kind of ResponseEntity of the POJO class "ErrorMessage"
	 * and taking the POJO ErrorMessage data filed as parameters and sending back the response
	 * 
	 * If there are several other methods for the other controller can be written here
	 */
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
													WebRequest request) {
		// TODO Auto-generated method stub

		ErrorMessage  errorMsg = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);
	}

	
	
}
