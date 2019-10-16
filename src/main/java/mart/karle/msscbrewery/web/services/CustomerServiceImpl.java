package mart.karle.msscbrewery.web.services;

import mart.karle.msscbrewery.web.command.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getCustomerById(final UUID beerId) {
    return CustomerDto.builder().id(UUID.randomUUID()).name("Jack").build();
  }

  @Override
  public CustomerDto saveNewCustomer(final CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID()).name("Jack New").build();
  }

  @Override
  public void updateCustomer(final UUID customerId, final CustomerDto customerDto) {
    customerDto.setId(customerId);
  }

  @Override
  public void deleteById(final UUID customerId) {}
}
