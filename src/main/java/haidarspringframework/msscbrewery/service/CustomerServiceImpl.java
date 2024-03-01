package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID()).name("majd").build();
    }
}
