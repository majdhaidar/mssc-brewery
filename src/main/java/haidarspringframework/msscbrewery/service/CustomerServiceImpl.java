package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.CreateCustomerDTO;
import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateCustomerReqDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID()).name("majd").build();
    }

    @Override
    public void update(UUID customerId, UpdateCustomerReqDTO updateCustomerReqDTO) {

    }

    @Override
    public void delete(UUID customerId) {

    }

    @Override
    public CustomerDTO saveNew(CreateCustomerDTO createCustomerDTO) {
        return CustomerDTO.builder().id(UUID.randomUUID()).name(createCustomerDTO.getName()).build();
    }
}
