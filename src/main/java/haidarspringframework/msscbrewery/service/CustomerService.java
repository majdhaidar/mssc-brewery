package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.CreateCustomerDTO;
import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateCustomerReqDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);

    void update(UUID customerId, UpdateCustomerReqDTO updateCustomerReqDTO);

    void delete(UUID customerId);

    CustomerDTO saveNew(CreateCustomerDTO createCustomerDTO);
}
