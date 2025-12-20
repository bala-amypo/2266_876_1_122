package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDiscountCodeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(
            @PathVariable Long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(service.updateDiscountCode(id, code));
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<DiscountCode>> byInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForInfluencer(id));
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<DiscountCode>> byCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCodesForCampaign(id));
    }
}
