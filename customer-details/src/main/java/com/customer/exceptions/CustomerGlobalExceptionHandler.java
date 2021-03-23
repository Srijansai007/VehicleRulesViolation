package com.customer.exceptions;

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

import com.customer.models.CustomErrorResponse;

/**
 * Custom exception handler for sending error response to client
 * 
 *
 */
@ControllerAdvice
public class CustomerGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
	// method to handle database exceptions
    @ExceptionHandler({CannotCreateTransactionException.class,DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDatabaseDownException(CannotCreateTransactionException ex, WebRequest request) {

        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }

    // method to handle customer customized exceptions
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<Object> handleCustomerException(CustomerException ex, WebRequest request) {

        HttpStatus status = (ex.getHttpStatus()==null)?HttpStatus.INTERNAL_SERVER_ERROR:ex.getHttpStatus();
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }
    // method to handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

       HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(buildCustomErrorResponse(ex,request,status), status);
    }
    // method to build error response
    private CustomErrorResponse buildCustomErrorResponse(Exception ex, WebRequest request,
			HttpStatus status) {
		 CustomErrorResponse errors = CustomErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.error(ex.getClass().getName())
				.status(status.value())
				.path(((ServletWebRequest) request).getRequest().getRequestURI())
				.build();
		 return errors;
	}
}