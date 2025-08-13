package com.avgeek.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favourites")
public class Favourite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fan_id", nullable = false)
    private User fan;
    
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    
    @Column(name = "added_date")
    private LocalDateTime addedDate;
    
    // Constructors
    public Favourite() {}
    
    public Favourite(User fan, Flight flight) {
        this.fan = fan;
        this.flight = flight;
        this.addedDate = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getFan() {
        return fan;
    }
    
    public void setFan(User fan) {
        this.fan = fan;
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    public LocalDateTime getAddedDate() {
        return addedDate;
    }
    
    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }
}
