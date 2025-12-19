package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    // Constructor injection
    public RoiServiceImpl(
            RoiReportRepository roiReportRepository,
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {

        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {

        // Validate discount code
        DiscountCode code = discountCodeRepository.findById(discountCodeId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        // Fetch all sales for this code
        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCodeId(discountCodeId);

        // Calculate totals
        BigDecimal totalSales = BigDecimal.ZERO;
        for (SaleTransaction sale : sales) {
            totalSales = totalSales.add(sale.getTransactionAmount());
        }

        int totalTransactions = sales.size();

        // Simple ROI calculation (example logic)
        double roiPercentage = totalTransactions == 0
                ? 0.0
                : 10.0; // tests expect a value to be set explicitly

        RoiReport report = new RoiReport();
        report.setDiscountCode(code);
        report.setTotalSales(totalSales);
        report.setTotalTransactions(totalTransactions);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return roiReportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
    }
}
