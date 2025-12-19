package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    // Constructor Injection
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    // GET /campaigns
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    // GET /campaigns/{id}
    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    // PUT /campaigns/{id}
    @PutMapping("/{id}")
    public Campaign updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }
}
