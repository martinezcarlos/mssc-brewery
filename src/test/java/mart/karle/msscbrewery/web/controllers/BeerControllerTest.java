package mart.karle.msscbrewery.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mart.karle.msscbrewery.web.command.BeerDto;
import mart.karle.msscbrewery.web.services.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @MockBean private BeerService beerService;

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  private BeerDto validBeer;

  @BeforeEach
  void setUp() {
    validBeer =
        BeerDto.builder()
            .id(UUID.randomUUID())
            .name("Beer1")
            .style("PALE_ALE")
            .upc(123456789012L)
            .build();
  }

  @Test
  void getBeer() throws Exception {
    given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

    mockMvc
        .perform(
            get("/api/v1/beers/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
        .andExpect(jsonPath("$.name", is("Beer1")));
  }

  @Test
  void handlePost() throws Exception {
    // given
    final BeerDto beerDto = validBeer;
    beerDto.setId(null);
    final BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).name("New Beer").build();
    final String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    given(beerService.saveNewBeer(any())).willReturn(savedDto);

    mockMvc
        .perform(
            post("/api/v1/beers/new").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
        .andExpect(status().isCreated());
  }

  @Test
  void handleUpdate() throws Exception {
    // given
    final BeerDto beerDto = validBeer;
    final String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    // when
    mockMvc
        .perform(
            put("/api/v1/beers/" + validBeer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
        .andExpect(status().isNoContent());

    then(beerService).should().updateBeer(any(), any());
  }
}
