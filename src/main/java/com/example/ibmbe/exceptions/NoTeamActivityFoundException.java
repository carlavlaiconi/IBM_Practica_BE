package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoTeamActivityFoundException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoTeamActivityFoundException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoTeamActivityFoundException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no team_activity with this id",cause);
        this.httpStatus=httpStatus;
    }
}
