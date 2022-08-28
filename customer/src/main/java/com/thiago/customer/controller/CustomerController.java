package com.thiago.customer.controller;

import com.thiago.customer.model.record.CustomerRegistrationRequest;
import com.thiago.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController{
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
