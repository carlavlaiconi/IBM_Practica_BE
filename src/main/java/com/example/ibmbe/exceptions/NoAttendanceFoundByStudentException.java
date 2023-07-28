package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoAttendanceFoundByStudentException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoAttendanceFoundByStudentException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoAttendanceFoundByStudentException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no attendance for this student",cause);
        this.httpStatus=httpStatus;
    }
}
