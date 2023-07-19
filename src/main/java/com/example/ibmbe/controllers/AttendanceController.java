package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{studentId}")
    public List<Attendance> getAttendanceByStudentId (@RequestParam final long studentId) {
        return attendanceService.getAttendanceByStudentId(studentId);
    }

    @GetMapping("/{sessionId}")
    public List<Attendance> getAttendanceBySessionId (@RequestParam final long sessionId) {
        return attendanceService.getAttendanceBySessionId(sessionId);
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody final Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance updatedAttendance) {
        Attendance attendance = attendanceService.updateAttendance(id, updatedAttendance);
        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
