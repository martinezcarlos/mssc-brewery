package mart.karle.msscbrewery.web.services;

import mart.karle.msscbrewery.web.command.CustomerDto;

import java.util.UUID;

public interface CustomerService {
  CustomerDto getCustomerById(UUID beerId);
}
