package haidarspringframework.msscbrewery.service;

import haidarspringframework.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
}
