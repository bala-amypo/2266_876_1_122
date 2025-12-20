package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    // UPDATE
    @PutMapping("/{id}")
    public Campaign updateCampaign(@PathVariable Long id,
                                   @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Campaign getCampaign(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    // READ ALL
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
}
