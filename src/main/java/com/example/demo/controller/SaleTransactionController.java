package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    // Constructor injection
    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.createSale(transaction);
    }

    @GetMapping("/code/{discountCodeId}")
    public List<SaleTransaction> getSalesForCode(@PathVariable Long discountCodeId) {
        return saleTransactionService.getSalesForCode(discountCodeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getSalesForInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getSalesForCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
}
