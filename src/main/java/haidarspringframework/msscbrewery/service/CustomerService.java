package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
}
