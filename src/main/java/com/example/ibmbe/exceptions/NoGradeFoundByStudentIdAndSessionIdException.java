package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoGradeFoundByStudentIdAndSessionIdException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoGradeFoundByStudentIdAndSessionIdException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoGradeFoundByStudentIdAndSessionIdException(HttpStatus httpStatus, Throwable cause)
    {
        super("There is no grade with this student id and session id",cause);
        this.httpStatus=httpStatus;
    }
}
