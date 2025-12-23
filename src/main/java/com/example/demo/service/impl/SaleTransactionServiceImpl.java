package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction saleTransaction) {
        return saleTransaction;
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
