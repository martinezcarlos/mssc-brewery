package mart.karle.msscbrewery.web.controllers;

import lombok.RequiredArgsConstructor;
import mart.karle.msscbrewery.web.command.BeerDto;
import mart.karle.msscbrewery.web.services.BeerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(BeerController.BASE_URL)
public class BeerController {
  static final String BASE_URL = "/api/v1/beer";

  private final BeerService beerService;

  @GetMapping("/{beerId}")
  public BeerDto getBeer(@PathVariable final UUID beerId) {
    return beerService.getBeerById(beerId);
  }
}
