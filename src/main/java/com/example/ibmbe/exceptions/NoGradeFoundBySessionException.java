package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoGradeFoundBySessionException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoGradeFoundBySessionException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoGradeFoundBySessionException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no grade for this session",cause);
        this.httpStatus=httpStatus;
    }
}
