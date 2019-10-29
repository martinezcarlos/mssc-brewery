package mart.karle.msscbrewery.web.mapper;

import mart.karle.msscbrewery.web.command.BeerDto;
import mart.karle.msscbrewery.web.model.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
  BeerDto entityToDto(Beer beer);

  Beer dtoToEntity(BeerDto dto);
}
