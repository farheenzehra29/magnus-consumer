package com.example.magnusconsumer.service.access;

import com.example.magnusconsumer.dto.CustomerDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceAccess {

    private RestTemplate restTemplate;

    public CustomerServiceAccess(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CustomerDto getCustomer(String uuid) {
        String url = "http://localhost:8080/customer/" + uuid;

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CustomerDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                CustomerDto.class);
        CustomerDto customerDto = responseEntity.getBody();
        return customerDto;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        String url = "http://localhost:8080/customer/create";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CustomerDto> requestEntity = new HttpEntity<>(customerDto, headers);

        ResponseEntity<CustomerDto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, CustomerDto.class);
        CustomerDto newCustomerDto = responseEntity.getBody();
        return newCustomerDto;


    }
}
