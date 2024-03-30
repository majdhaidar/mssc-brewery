package haidarspringframework.msscbrewery.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBeerDTO {
    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;
}
