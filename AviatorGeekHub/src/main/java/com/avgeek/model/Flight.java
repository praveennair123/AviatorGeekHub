package com.avgeek.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(name = "flight_number")
    private String flightNumber;
    
    @NotBlank
    private String origin;
    
    @NotBlank
    private String destination;
    
    @NotBlank
    private String status;
    
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    
    private String aircraft;
    
    @ManyToOne
    @JoinColumn(name = "pilot_id")
    private User pilot;
    
    // Constructors
    public Flight() {}
    
    public Flight(String flightNumber, String origin, String destination, String status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
    
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public String getAircraft() {
        return aircraft;
    }
    
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    
    public User getPilot() {
        return pilot;
    }
    
    public void setPilot(User pilot) {
        this.pilot = pilot;
    }
}
