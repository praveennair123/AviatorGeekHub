package com.avgeek.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "spotter_submissions")
public class SpotterSubmission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "spotter_id", nullable = false)
    private User spotter;
    
    @NotBlank
    private String aircraft;
    
    @NotBlank
    private String location;
    
    @Column(name = "photo_path")
    private String photoPath;
    
    private String description;
    
    private boolean approved = false;
    
    @Column(name = "submission_date")
    private LocalDateTime submissionDate;
    
    @Column(name = "approval_date")
    private LocalDateTime approvalDate;
    
    // Constructors
    public SpotterSubmission() {}
    
    public SpotterSubmission(User spotter, String aircraft, String location, String description) {
        this.spotter = spotter;
        this.aircraft = aircraft;
        this.location = location;
        this.description = description;
        this.submissionDate = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getSpotter() {
        return spotter;
    }
    
    public void setSpotter(User spotter) {
        this.spotter = spotter;
    }
    
    public String getAircraft() {
        return aircraft;
    }
    
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getPhotoPath() {
        return photoPath;
    }
    
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isApproved() {
        return approved;
    }
    
    public void setApproved(boolean approved) {
        this.approved = approved;
        if (approved && this.approvalDate == null) {
            this.approvalDate = LocalDateTime.now();
        }
    }
    
    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }
    
    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }
    
    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }
    
    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }
}
