package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    // Constructor injection
    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/code/{discountCodeId}")
    public RoiReport generateReportForCode(@PathVariable Long discountCodeId) {
        return roiService.generateReportForCode(discountCodeId);
    }

    @GetMapping("/{reportId}")
    public RoiReport getReportById(@PathVariable Long reportId) {
        return roiService.getReportById(reportId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getReportsForInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }
}
