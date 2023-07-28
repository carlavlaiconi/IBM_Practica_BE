package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoActivityFoundByTeamException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoActivityFoundByTeamException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoActivityFoundByTeamException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no activity for this team",cause);
        this.httpStatus=httpStatus;
    }
}
