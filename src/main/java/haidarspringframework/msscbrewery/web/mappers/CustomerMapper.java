package haidarspringframework.msscbrewery.web.mappers;

import haidarspringframework.msscbrewery.domain.Customer;
import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
