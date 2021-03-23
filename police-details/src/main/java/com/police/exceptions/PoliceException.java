package com.police.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class PoliceException extends Exception {


	private static final long serialVersionUID = 637567139756180314L;
	private  String exceptionType;
	private  HttpStatus httpStatus;


    public PoliceException(Exception exception, String string) {
        super(string);
        this.exceptionType = exception.getClass().getSimpleName();
    }

 
    public PoliceException(String string,HttpStatus httpStatus) {
        super(string);
        this.httpStatus = httpStatus;
    }

}