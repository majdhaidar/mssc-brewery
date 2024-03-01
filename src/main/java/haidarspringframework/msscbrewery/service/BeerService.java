package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.BeerDTO;
import haidarspringframework.msscbrewery.web.model.CreateBeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNew(CreateBeerDTO createBeerDTO);
}
