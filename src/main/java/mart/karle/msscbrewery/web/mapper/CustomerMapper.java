package mart.karle.msscbrewery.web.mapper;

import mart.karle.msscbrewery.web.command.CustomerDto;
import mart.karle.msscbrewery.web.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
  CustomerDto entityToDto(Customer beer);

  Customer dtoToEntity(CustomerDto dto);
}
