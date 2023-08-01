package com.example.ibmbe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.ibmbe.dto.ExceptionResponseDto;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoUserFoundException(NoUserFoundException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoUserFoundByTeamException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoUserFoundByTeamException(NoUserFoundByTeamException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoTeamFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoTeamFoundException(NoTeamFoundException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoTeamFoundByActivityException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoTeamFoundByActivityException(NoTeamFoundByActivityException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoSessionFoundByActivityException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoSessionFoundByActivityException(NoSessionFoundByActivityException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoGradeFoundByStudentException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoGradeFoundByStudentException(NoGradeFoundByStudentException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoGradeFoundBySessionException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoGradeFoundBySessionException(NoGradeFoundBySessionException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoAttendanceFoundByStudentException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoAttendanceFoundByStudentException(NoAttendanceFoundByStudentException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoAttendanceFoundBySessionException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoAttendanceFoundBySessionException(NoAttendanceFoundBySessionException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoActivityFoundByTeamException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoActivityFoundByTeamException(NoActivityFoundByTeamException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoUserFoundByTeamIdAndEmailException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoUserFoundByTeamIdAndEmailException(NoUserFoundByTeamIdAndEmailException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoGradeFoundByStudentIdAndSessionIdException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoGradeFoundByStudentIdAndSessionIdException(NoGradeFoundByStudentIdAndSessionIdException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoGradeFoundByMentorIdAndSessionIdException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoGradeFoundByMentorIdAndSessionIdException(NoGradeFoundByMentorIdAndSessionIdException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(NoAttendanceFoundByStudentIdAndSessionIdException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictNoAttendanceFoundByStudentIdAndSessionIdException(NoAttendanceFoundByStudentIdAndSessionIdException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflictRuntimeException(RuntimeException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong",
                "An internal server issue occurred"
        );

        return ResponseEntity.ok().body(responseDto);
    }

}
