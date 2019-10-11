package mart.karle.msscbrewery.web.controllers;

import lombok.RequiredArgsConstructor;
import mart.karle.msscbrewery.web.command.CustomerDto;
import mart.karle.msscbrewery.web.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
  static final String BASE_URL = "/api/v1/customers";

  private final CustomerService customerService;

  @GetMapping("/{customerId}")
  public CustomerDto getCustomer(@PathVariable final UUID customerId) {
    return customerService.getCustomerById(customerId);
  }
}
