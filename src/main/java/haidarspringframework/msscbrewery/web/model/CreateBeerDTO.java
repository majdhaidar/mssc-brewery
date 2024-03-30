package haidarspringframework.msscbrewery.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBeerDTO {
    @NotBlank
    @NotNull
    @Length(min = 3, max = 255)
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;
}
