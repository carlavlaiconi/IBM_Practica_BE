package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudentId (@RequestParam final long studentId) {
        return attendanceService.getAttendanceByStudentId(studentId);
    }

    @GetMapping("/session/{sessionId}")
    public List<Attendance> getAttendanceBySessionId (@RequestParam final long sessionId) {
        return attendanceService.getAttendanceBySessionId(sessionId);
    }

    @GetMapping("/student&session/{studentId}{sessionId}")
    public List<Attendance> getAttendanceByStudentIdAndSessionId (@RequestParam final long studentId, @RequestParam final long sessionId) {
        return attendanceService.getAttendanceByStudentIdAndSessionId(studentId, sessionId);
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody final Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }


    @PutMapping("/{studentId}{sessionId}")
    public ResponseEntity<Attendance> updateAttendanceByStudentIdAndSessionId(@RequestParam Long studentId, @RequestParam Long sessionId) {
        Attendance attendance = attendanceService.updateAttendanceByStudentIdAndSessionId(studentId, sessionId);
        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
