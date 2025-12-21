package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {

        if (transaction.getTransactionAmount().signum() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        // ✅ FIXED: Timestamp, NOT LocalDateTime
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(
                    new Timestamp(System.currentTimeMillis())
            );
        }

        return transaction;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return List.of();
    }
}
