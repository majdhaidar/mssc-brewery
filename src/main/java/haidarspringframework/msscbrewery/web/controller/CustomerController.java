package haidarspringframework.msscbrewery.web.controller;

import haidarspringframework.msscbrewery.service.CustomerService;
import haidarspringframework.msscbrewery.web.model.CreateCustomerDTO;
import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateCustomerReqDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{customerId}")
    ResponseEntity<CustomerDTO> returnCustomerById(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    @PostMapping
    ResponseEntity saveNew(@RequestBody CreateCustomerDTO createCustomerDTO) {
        CustomerDTO customerDTO = customerService.saveNew(createCustomerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "/api/v1/customer/" + customerDTO.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody UpdateCustomerReqDTO updateCustomerReqDTO) {
        customerService.update(customerId, updateCustomerReqDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.delete(customerId);
    }
}
