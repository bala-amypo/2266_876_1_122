package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.time.LocalDateTime;

@Entity
public class Influencer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
