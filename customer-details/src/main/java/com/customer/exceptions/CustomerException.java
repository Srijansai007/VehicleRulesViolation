package com.customer.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerException extends Exception {

 
	private static final long serialVersionUID = 637567139756180314L;
	private  String exceptionType;
	private  HttpStatus httpStatus;

    public CustomerException(Exception exception, String string) {
        super(string);
        this.exceptionType = exception.getClass().getSimpleName();
    }


    public CustomerException(String string,HttpStatus httpStatus) {
        super(string);
        this.httpStatus = httpStatus;
    }

}