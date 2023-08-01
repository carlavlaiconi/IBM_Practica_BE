package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoAttendanceFoundByStudentIdAndSessionIdException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoAttendanceFoundByStudentIdAndSessionIdException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoAttendanceFoundByStudentIdAndSessionIdException(HttpStatus httpStatus, Throwable cause)
    {
        super("There is no attendance with this student id and session id",cause);
        this.httpStatus=httpStatus;
    }
}
