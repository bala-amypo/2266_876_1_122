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


}
