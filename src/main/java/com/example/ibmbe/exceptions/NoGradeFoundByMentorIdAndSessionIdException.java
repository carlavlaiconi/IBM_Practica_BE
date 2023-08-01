package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoGradeFoundByMentorIdAndSessionIdException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoGradeFoundByMentorIdAndSessionIdException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoGradeFoundByMentorIdAndSessionIdException(HttpStatus httpStatus, Throwable cause)
    {
        super("There is no grade with this mentor id and session id",cause);
        this.httpStatus=httpStatus;
    }
}
