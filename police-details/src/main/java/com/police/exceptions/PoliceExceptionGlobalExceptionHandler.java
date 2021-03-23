package com.police.exceptions;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.police.models.PoliceErrorResponse;

@ControllerAdvice
public class PoliceExceptionGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
	// method to handle database exceptions
    @ExceptionHandler({CannotCreateTransactionException.class,DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDatabaseDownException(CannotCreateTransactionException ex, WebRequest request) {

        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }

 // method to handle police customized exceptions
    @ExceptionHandler(PoliceException.class)
    public ResponseEntity<Object> handleCustomerException(PoliceException ex, WebRequest request) {

        HttpStatus status = (ex.getHttpStatus()==null)?HttpStatus.INTERNAL_SERVER_ERROR:ex.getHttpStatus();
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }
    
 // method to handle all exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

       HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }
 // method to build exception response
    private PoliceErrorResponse buildCustomErrorResponse(Exception ex, WebRequest request,
			HttpStatus status) {
		 PoliceErrorResponse errors = PoliceErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.error(ex.getClass().getName())
				.status(status.value())
				.path(((ServletWebRequest) request).getRequest().getRequestURI())
				.build();
		 return errors;
	}
}