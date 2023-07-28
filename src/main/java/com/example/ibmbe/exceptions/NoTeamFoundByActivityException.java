package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoTeamFoundByActivityException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoTeamFoundByActivityException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoTeamFoundByActivityException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no team in this activity",cause);
        this.httpStatus=httpStatus;
    }
}
