package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Integer discountPercentage;

    private Boolean active = true;

    @ManyToOne
  @JoinColumn(name = "influencer_id", nullable = false)
private Influencer influencer;




}