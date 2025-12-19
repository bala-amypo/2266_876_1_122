package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    // Constructor injection
    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode updated) {

        return discountCodeService.updateDiscountCode(id, updated);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesForInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesForCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
