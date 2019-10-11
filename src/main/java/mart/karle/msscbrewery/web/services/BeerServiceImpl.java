package mart.karle.msscbrewery.web.services;

import mart.karle.msscbrewery.web.command.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto getBeerById(final UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID()).name("Galaxy Cat").style("Pale Ale").build();
  }
}
