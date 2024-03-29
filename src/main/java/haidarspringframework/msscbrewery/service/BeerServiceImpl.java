package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.BeerDTO;
import haidarspringframework.msscbrewery.web.model.CreateBeerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateBeerReqDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID()).beerName("Almaza").beerStyle("Greeno").upc(2L).build();
    }

    @Override
    public BeerDTO saveNew(CreateBeerDTO createBeerDTO) {
        return BeerDTO.builder().id(UUID.randomUUID()).beerName(createBeerDTO.getBeerName()).beerStyle(createBeerDTO.getBeerStyle()).upc(createBeerDTO.getUpc()).build();
    }

    @Override
    public void updateBeer(UUID beerId, UpdateBeerReqDTO updateBeerReqDTO) {
        //Implement update beer process
    }

    @Override
    public void delete(UUID beerId) {
        //Implement delete beer process
    }
}
