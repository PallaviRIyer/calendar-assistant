package com.example.calendarassistant.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    // Constructors, getters, and setters
    public Meeting() {}

    public Meeting(LocalDateTime startTime, LocalDateTime endTime, Calendar calendar) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.calendar = calendar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
