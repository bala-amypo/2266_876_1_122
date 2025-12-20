package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    // CREATE
    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.createSale(transaction);
    }

    // READ BY DISCOUNT CODE
    @GetMapping("/code/{discountCodeId}")
    public List<SaleTransaction> getSalesForCode(@PathVariable Long discountCodeId) {
        return saleTransactionService.getSalesForCode(discountCodeId);
    }

    // READ BY INFLUENCER
    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getSalesForInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    // READ BY CAMPAIGN
    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getSalesForCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
}
