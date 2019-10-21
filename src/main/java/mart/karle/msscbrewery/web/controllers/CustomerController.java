package mart.karle.msscbrewery.web.controllers;

import lombok.RequiredArgsConstructor;
import mart.karle.msscbrewery.web.command.CustomerDto;
import mart.karle.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

  @PostMapping("/new")
  public ResponseEntity<CustomerDto> saveNewCustomer(
      @Valid @RequestBody final CustomerDto customerDto) {
    final CustomerDto createdDto = customerService.saveNewCustomer(customerDto);
    // TODO: add hostname to url
    return ResponseEntity.status(HttpStatus.CREATED)
        .header("Location", BASE_URL + "/" + createdDto.getId().toString())
        .body(createdDto);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<Void> updateCustomer(
      @PathVariable final UUID customerId, @Valid @RequestBody final CustomerDto customerDto) {
    customerService.updateCustomer(customerId, customerDto);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .header("Location", BASE_URL + "/" + customerId.toString())
        .build();
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable final UUID customerId) {
    customerService.deleteById(customerId);
  }
}
