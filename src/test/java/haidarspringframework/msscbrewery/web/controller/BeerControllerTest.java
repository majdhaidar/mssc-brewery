package haidarspringframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import haidarspringframework.msscbrewery.service.BeerService;
import haidarspringframework.msscbrewery.web.model.BeerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDTO validBeerDTO;

    @BeforeEach
    public void setUp() {
        validBeerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerStyle("Mexican").beerName("Almaza").upc(123321231L).build();
    }

    /**
     * Method implemented to test get beer by id endpoint
     *
     * @throws Exception
     */
    @Test
    void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeerDTO);

        mockMvc.perform(get("/api/v1/beer/" + validBeerDTO.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeerDTO.getId().toString())))
                .andExpect(jsonPath("$.beerName", is(validBeerDTO.getBeerName())));
    }

    /**
     * Method implemented to test save new beer endpoint
     *
     * @throws Exception
     */
    @Test
    void saveNew() throws Exception {
        BeerDTO beerDTO = validBeerDTO;
        beerDTO.setId(null);
        BeerDTO savedBeerDto = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Beer").build();

        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.saveNew(any())).willReturn(savedBeerDto);

        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
    }

    /**
     * Method implemented to test update beer endpoint
     *
     * @throws Exception
     */
    @Test
    void updateBeer() throws Exception {
        //given
        BeerDTO beerDto = validBeerDTO;
        beerDto.setId(null);
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }
}