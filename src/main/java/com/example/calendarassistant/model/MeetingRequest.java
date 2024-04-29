package com.example.calendarassistant.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class MeetingRequest {
    private Long calendarId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration meetingDuration;
    private List<Long> participantIds;

    public List<Long> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Long> participantIds) {
        this.participantIds = participantIds;
    }

    // Constructors, getters, and setters
    public MeetingRequest() {}

    public MeetingRequest(Long calendarId, LocalDateTime startTime, LocalDateTime endTime, Duration meetingDuration) {
        this.calendarId = calendarId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingDuration = meetingDuration;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Duration getMeetingDuration() {
        return meetingDuration;
    }

    public void setMeetingDuration(Duration meetingDuration) {
        this.meetingDuration = meetingDuration;
    }
}

