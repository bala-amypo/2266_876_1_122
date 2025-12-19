package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    // Constructor Injection
    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // POST /influencers
    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    // GET /influencers
    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }

    // GET /influencers/{id}
    @GetMapping("/{id}")
    public Influencer getInfluencerById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }
}
