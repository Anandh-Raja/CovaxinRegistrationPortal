 package com.wipro.covaxin.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	//handle specific exception
	
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public @ResponseBody
//    String handleResourceNotFound(final ResourceNotFoundException exception,
//                                          final HttpServletRequest request) {
//        return exception.getMessage();
//    }
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request )
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
    
//    @ExceptionHandler(DuplicateResourceException.class)
//    @ResponseStatus(value = HttpStatus.CONFLICT)
//    public @ResponseBody
//    String handleDuplicateResource(final DuplicateResourceException exception,
//                                             final HttpServletRequest request) {
//
//        return exception.getMessage();
//    }
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<?> handleDuplicateResourceException(DuplicateResourceException exception,WebRequest request )
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
    
    //handle global exception

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public @ResponseBody String handleException(final Exception exception,
//                                                           final HttpServletRequest request) {
//        return exception.getMessage();
//    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request )
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
//    //handle custom validation error
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
//    public @ResponseBody String customValidationErrorHandling(MethodArgumentNotValidException exception)
//    {
//    	return exception.getMessage();
//    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception,WebRequest request )
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), "Validation error", exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
