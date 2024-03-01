package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID()).beerName("Almaza").beerStyle("Greeno").upc(2L).build();
    }
}
