package haidarspringframework.msscbrewery.web.controller;

import haidarspringframework.msscbrewery.service.BeerService;
import haidarspringframework.msscbrewery.web.model.BeerDTO;
import haidarspringframework.msscbrewery.web.model.CreateBeerDTO;
import haidarspringframework.msscbrewery.web.model.UpdateBeerReqDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/beer")
@Slf4j
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    ResponseEntity<BeerDTO> getBeer(@PathVariable @NotNull UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity saveNew(@RequestBody @Valid @NotNull CreateBeerDTO createBeerDTO) {
        BeerDTO beerDTO = beerService.saveNew(createBeerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "/api/v1/beer/" + beerDTO.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody @Valid UpdateBeerReqDTO updateBeerReqDTO) {
        beerService.updateBeer(beerId, updateBeerReqDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBeer(@PathVariable("beerId") @NotNull UUID beerId) {
        beerService.delete(beerId);
    }
}
