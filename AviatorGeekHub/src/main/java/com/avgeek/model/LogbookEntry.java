package com.avgeek.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "logbook_entries")
public class LogbookEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pilot_id", nullable = false)
    private User pilot;
    
    @NotNull
    @Column(name = "flight_date")
    private LocalDate flightDate;
    
    @NotBlank
    private String aircraft;
    
    @NotNull
    @Column(name = "duration_hours")
    private Double durationHours;
    
    @Column(name = "flight_number")
    private String flightNumber;
    
    private String origin;
    private String destination;
    private String remarks;
    
    // Constructors
    public LogbookEntry() {}
    
    public LogbookEntry(User pilot, LocalDate flightDate, String aircraft, Double durationHours) {
        this.pilot = pilot;
        this.flightDate = flightDate;
        this.aircraft = aircraft;
        this.durationHours = durationHours;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getPilot() {
        return pilot;
    }
    
    public void setPilot(User pilot) {
        this.pilot = pilot;
    }
    
    public LocalDate getFlightDate() {
        return flightDate;
    }
    
    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }
    
    public String getAircraft() {
        return aircraft;
    }
    
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    
    public Double getDurationHours() {
        return durationHours;
    }
    
    public void setDurationHours(Double durationHours) {
        this.durationHours = durationHours;
    }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
