package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SaleTransaction;

public interface SaleTransactionService {

    SaleTransaction createSale(SaleTransaction transaction);

    List<SaleTransaction> getSalesForCode(Long discountCodeId);

    List<SaleTransaction> getSalesForInfluencer(Long influencerId);

    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
