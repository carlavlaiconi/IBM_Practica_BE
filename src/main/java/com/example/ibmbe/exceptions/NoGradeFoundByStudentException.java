package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoGradeFoundByStudentException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoGradeFoundByStudentException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoGradeFoundByStudentException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no grade for this student",cause);
        this.httpStatus=httpStatus;
    }
}
