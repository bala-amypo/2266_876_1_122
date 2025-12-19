package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    // Constructor injection
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {

        Campaign existingCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        // Business rule: endDate must not be before startDate
        if (campaign.getStartDate() != null && campaign.getEndDate() != null) {
            if (campaign.getEndDate().isBefore(campaign.getStartDate())) {
                throw new IllegalArgumentException("Invalid campaign date range");
            }
        }

        existingCampaign.setCampaignName(campaign.getCampaignName());
        existingCampaign.setStartDate(campaign.getStartDate());
        existingCampaign.setEndDate(campaign.getEndDate());

        return campaignRepository.save(existingCampaign);
    }
}
