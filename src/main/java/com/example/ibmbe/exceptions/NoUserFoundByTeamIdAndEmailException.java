package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoUserFoundByTeamIdAndEmailException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoUserFoundByTeamIdAndEmailException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoUserFoundByTeamIdAndEmailException(HttpStatus httpStatus, Throwable cause)
    {
        super("There is no user with this team id and email",cause);
        this.httpStatus=httpStatus;
    }
}
