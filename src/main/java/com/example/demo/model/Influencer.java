package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.time.LocalDateTime;

@Entity
public class Influencer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String socialHandle;

    private String email;

    private Boolean active =true;

    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for socialHandle
    public String getSocialHandle() {
        return socialHandle;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for active
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    // Getter for createdAt (no setter needed usually)
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


}
