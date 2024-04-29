package com.example.calendarassistant.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String description;


    // Constructors, getters, and setters
    public Calendar() {}

    public Calendar(String owner, String description) {
        this.owner = owner;
        this.description = description;
    }
    public Calendar(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

