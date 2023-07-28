package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoSessionFoundByActivityException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoSessionFoundByActivityException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoSessionFoundByActivityException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no session for this activity",cause);
        this.httpStatus=httpStatus;
    }
}
