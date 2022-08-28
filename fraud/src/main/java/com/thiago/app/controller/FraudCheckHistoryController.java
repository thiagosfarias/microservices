package com.thiago.app.controller;

import com.thiago.app.service.FraudCheckService;
import com.thiago.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckHistoryController {
    private FraudCheckService service;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFrauder(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = service.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
