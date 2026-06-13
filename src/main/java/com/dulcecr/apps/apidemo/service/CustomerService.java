package com.dulcecr.apps.apidemo.service;

import com.dulcecr.apps.apidemo.dto.CustomerRequest;
import com.dulcecr.apps.apidemo.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerResponse create(CustomerRequest request);
}
