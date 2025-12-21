package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction transaction) {
        return ResponseEntity.ok(saleTransactionService.createSale(transaction));
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long id) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCode(id));
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<SaleTransaction>> getSalesForInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(saleTransactionService.getSalesForInfluencer(id));
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(saleTransactionService.getSalesForCampaign(id));
    }
}
