package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    // Constructor injection
    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {

        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {

        // Validation: transaction amount must be > 0
        if (transaction.getTransactionAmount() == null
                || transaction.getTransactionAmount().signum() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        // Validate discount code
        Long codeId = transaction.getDiscountCode().getId();
        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        transaction.setDiscountCode(code);

        // Set transaction date if not provided
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        }

        return saleTransactionRepository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
    }
}
