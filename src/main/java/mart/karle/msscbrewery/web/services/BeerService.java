package mart.karle.msscbrewery.web.services;

import mart.karle.msscbrewery.web.command.BeerDto;

import java.util.UUID;

public interface BeerService {
  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beerDto);
}
