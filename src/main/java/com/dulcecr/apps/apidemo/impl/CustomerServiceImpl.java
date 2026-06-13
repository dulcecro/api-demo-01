package com.dulcecr.apps.apidemo.impl;

import com.dulcecr.apps.apidemo.dto.CustomerRequest;
import com.dulcecr.apps.apidemo.dto.CustomerResponse;
import com.dulcecr.apps.apidemo.entity.CustomerEntity;
import com.dulcecr.apps.apidemo.repository.CustomerRepository;
import com.dulcecr.apps.apidemo.service.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

     @Override
     public List<CustomerResponse> findAll() {
          return customerRepository.findAll()
                  .stream()
                  .map(this::toResponse)
                  .toList();
     }

    @Override
    @Transactional // Obligatorio cuando se realice commit
    public CustomerResponse create(CustomerRequest request) {
        var entity = this.toEntity(request);
        customerRepository.persist(entity);
        return this.toResponse(entity);
    }

    //Mapstruct
     CustomerResponse toResponse(CustomerEntity entity) {
        return new CustomerResponse(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthOfDate()
        );
     }

     CustomerEntity toEntity(CustomerRequest request) {
        return new CustomerEntity(
                null,
                request.firstName(),
                request.lastName(),
                request.birthOfDate(),
                LocalDateTime.now()
        );
     }
}
