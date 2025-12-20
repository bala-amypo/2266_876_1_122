package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // CREATE
    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Influencer getInfluencer(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    // READ ALL
    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }
}
