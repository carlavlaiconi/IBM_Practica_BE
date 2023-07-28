package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoUserFoundByTeamException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoUserFoundByTeamException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoUserFoundByTeamException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no user in this team",cause);
        this.httpStatus=httpStatus;
    }
}
