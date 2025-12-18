package com.example.demo.model;

import jakarta.persistence.*;
import java.BigDecimal;
import java.time.LocalDate;

@Entity

public class Campaign{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private BigDecimal budget;


}