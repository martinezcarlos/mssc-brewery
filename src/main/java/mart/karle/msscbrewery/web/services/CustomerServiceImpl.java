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
}
