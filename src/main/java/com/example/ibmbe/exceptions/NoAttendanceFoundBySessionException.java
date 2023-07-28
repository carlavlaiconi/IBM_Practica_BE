package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;

public class NoAttendanceFoundBySessionException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NoAttendanceFoundBySessionException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public NoAttendanceFoundBySessionException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no attendance for this session",cause);
        this.httpStatus=httpStatus;
    }
}
