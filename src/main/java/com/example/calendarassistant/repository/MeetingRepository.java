package com.example.calendarassistant.repository;

import com.example.calendarassistant.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByCalendarId(Long calendarId);
    @Query("SELECT m FROM Meeting m WHERE m.calendar.id = :calendarId AND " +
            "(m.startTime BETWEEN :start AND :end OR m.endTime BETWEEN :start AND :end) " +
            "AND m.id <> :meetingId")
    List<Meeting> findConflictingMeetings(Long calendarId, LocalDateTime start, LocalDateTime end, Long meetingId);

    List<Meeting> findAllByCalendarId(Long calendarId);
}

