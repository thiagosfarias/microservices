package com.thiago.app.service;

import com.thiago.app.model.FraudCheckHistory;
import com.thiago.app.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService{
    private final FraudCheckHistoryRepository repository;
    public Boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFrauder(false)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(fraudCheckHistory);

        return false;
    }
}
