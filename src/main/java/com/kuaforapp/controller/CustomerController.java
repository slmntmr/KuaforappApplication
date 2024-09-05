package com.kuaforapp.controller;


import com.kuaforapp.dto.Request.CustomerRequest;
import com.kuaforapp.dto.Response.CustomerResponse;
import com.kuaforapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest requestDTO) {
        return customerService.createCustomer(requestDTO);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
