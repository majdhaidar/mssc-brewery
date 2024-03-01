package haidarspringframework.msscbrewery.web.controller;

import haidarspringframework.msscbrewery.service.BeerService;
import haidarspringframework.msscbrewery.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BearController {

    private final BeerService beerService;

    public BearController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
}
