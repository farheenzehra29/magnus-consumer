package com.example.magnusconsumer.controller;

import com.example.magnusconsumer.dto.CustomerDto;
import com.example.magnusconsumer.service.access.CustomerServiceAccess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class MagnusConsumerController {

    private CustomerServiceAccess customerServiceAccess;

    public MagnusConsumerController(CustomerServiceAccess customerServiceAccess) {
        this.customerServiceAccess = customerServiceAccess;

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDto> findById(@PathVariable String uuid) {
        CustomerDto customerDto = customerServiceAccess.getCustomer(uuid);
        return ResponseEntity.ok(customerDto);

    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createById(@RequestBody CustomerDto customerDto) {
        CustomerDto newCustomerDto = customerServiceAccess.createCustomer(customerDto);
        return ResponseEntity.ok(newCustomerDto);

    }
}
