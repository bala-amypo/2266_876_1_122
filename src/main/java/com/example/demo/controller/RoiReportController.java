package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    // GENERATE ROI FOR DISCOUNT CODE
    @PostMapping("/code/{discountCodeId}")
    public RoiReport generateReportForCode(@PathVariable Long discountCodeId) {
        return roiService.generateReportForCode(discountCodeId);
    }

    // READ ROI BY ID
    @GetMapping("/{reportId}")
    public RoiReport getReport(@PathVariable Long reportId) {
        return roiService.getReportById(reportId);
    }

    // READ ROI BY INFLUENCER
    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getReportsForInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }
}
