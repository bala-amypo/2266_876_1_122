package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RoiReport;

public interface RoiService {

    RoiReport generateReportForCode(Long discountCodeId);

    RoiReport getReportById(Long reportId);

    List<RoiReport> getReportsForInfluencer(Long influencerId);
}
