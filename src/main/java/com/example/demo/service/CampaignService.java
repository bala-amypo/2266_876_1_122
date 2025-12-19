package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Campaign;

public interface CampaignService {

    Campaign getCampaignById(Long id);

    List<Campaign> getAllCampaigns();

    Campaign updateCampaign(Long id, Campaign campaign);
}
