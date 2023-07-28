package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoTeamFoundException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoTeamFoundException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoTeamFoundException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no team with this id",cause);
        this.httpStatus=httpStatus;
    }
}
