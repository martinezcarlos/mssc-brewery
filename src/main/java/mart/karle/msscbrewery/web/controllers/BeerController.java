package mart.karle.msscbrewery.web.controllers;

import lombok.RequiredArgsConstructor;
import mart.karle.msscbrewery.web.command.BeerDto;
import mart.karle.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(BeerController.BASE_URL)
public class BeerController {
  static final String BASE_URL = "/api/v1/beers";

  private final BeerService beerService;

  @GetMapping("/{beerId}")
  public BeerDto getBeer(@PathVariable final UUID beerId) {
    return beerService.getBeerById(beerId);
  }

  @PostMapping("/new")
  public ResponseEntity<BeerDto> saveNewBeer(@RequestBody final BeerDto beerDto) {
    final BeerDto createdDto = beerService.saveNewBeer(beerDto);
    //TODO: add hostname to url
    return ResponseEntity.status(HttpStatus.CREATED)
        .header("Location", BASE_URL + "/" + createdDto.getId().toString())
        .body(createdDto);
  }
}
