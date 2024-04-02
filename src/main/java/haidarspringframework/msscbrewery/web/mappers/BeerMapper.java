package haidarspringframework.msscbrewery.web.mappers;

import haidarspringframework.msscbrewery.domain.Beer;
import haidarspringframework.msscbrewery.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDtoToBeer(BeerDTO beerDTO);
}
