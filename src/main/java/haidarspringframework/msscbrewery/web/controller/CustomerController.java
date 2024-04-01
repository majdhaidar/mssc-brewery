package haidarspringframework.msscbrewery.web.controller;

import haidarspringframework.msscbrewery.service.CustomerService;
import haidarspringframework.msscbrewery.web.model.CreateCustomerDTO;
import haidarspringframework.msscbrewery.web.model.CustomerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateCustomerReqDTO;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
@Slf4j
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("{customerId}")
    ResponseEntity<CustomerDTO> returnCustomerById(@PathVariable("customerId") @NotNull UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    @PostMapping
    ResponseEntity saveNew(@RequestBody @Validated CreateCustomerDTO createCustomerDTO) {
        CustomerDTO customerDTO = customerService.saveNew(createCustomerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "/api/v1/customer/" + customerDTO.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    ResponseEntity updateCustomer(@PathVariable("customerId") @NotNull UUID customerId, @RequestBody UpdateCustomerReqDTO updateCustomerReqDTO) {
        customerService.update(customerId, updateCustomerReqDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable("customerId") @NotNull UUID customerId) {
        customerService.delete(customerId);
    }
}
