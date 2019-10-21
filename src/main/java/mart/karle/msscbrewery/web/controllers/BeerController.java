package mart.karle.msscbrewery.web.controllers;

import lombok.RequiredArgsConstructor;
import mart.karle.msscbrewery.web.command.BeerDto;
import mart.karle.msscbrewery.web.services.BeerService;
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
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
  public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody final BeerDto beerDto) {
    final BeerDto createdDto = beerService.saveNewBeer(beerDto);
    final URI location =
        UriComponentsBuilder.fromUriString(BASE_URL)
            .pathSegment(createdDto.getId().toString())
            .build()
            .toUri();
    return ResponseEntity.created(location).body(createdDto);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Void> updateBeer(
      @PathVariable final UUID beerId, @Valid @RequestBody final BeerDto beerDto) {
    beerService.updateBeer(beerId, beerDto);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .header("Location", BASE_URL + "/" + beerId.toString())
        .build();
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@Valid @PathVariable final UUID beerId) {
    beerService.deleteById(beerId);
  }
}
