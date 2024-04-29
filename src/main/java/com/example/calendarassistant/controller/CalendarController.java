package com.example.calendarassistant.controller;


import com.example.calendarassistant.model.Calendar;
import com.example.calendarassistant.model.CalendarRequest;
import com.example.calendarassistant.model.Meeting;
import com.example.calendarassistant.model.MeetingRequest;
import com.example.calendarassistant.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping("/create")
    public ResponseEntity<Calendar> createCalendar(@RequestBody CalendarRequest request) {
        Calendar calendar = calendarService.createCalendar(request);
        return new ResponseEntity<>(calendar, HttpStatus.CREATED);
    }
    @GetMapping("/freeslots")
    public ResponseEntity<List<LocalDateTime>> findFreeSlots(@RequestParam Long calendarId, @RequestParam Duration meetingDuration) {
        List<LocalDateTime> freeSlots = calendarService.findFreeSlots(calendarId, meetingDuration);
        return new ResponseEntity<>(freeSlots, HttpStatus.OK);
    }

    @PostMapping("/conflicts")
    public ResponseEntity<List<String>> checkForConflicts(@RequestBody MeetingRequest request) {
        List<String> conflicts = calendarService.checkForConflicts(request);
        return new ResponseEntity<>(conflicts, HttpStatus.OK);

    }

    @PostMapping("/book")
    public ResponseEntity<Meeting> bookMeeting(@RequestBody MeetingRequest request) {
        Meeting meeting = calendarService.bookMeeting(request);
        return new ResponseEntity<>(meeting, HttpStatus.CREATED);
    }
}
