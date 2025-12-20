package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    // READ BY ID
    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(@PathVariable Long id,
                                           @RequestBody DiscountCode code) {
        return discountCodeService.updateDiscountCode(id, code);
    }

    // READ BY INFLUENCER
    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesForInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    // READ BY CAMPAIGN
    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesForCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
