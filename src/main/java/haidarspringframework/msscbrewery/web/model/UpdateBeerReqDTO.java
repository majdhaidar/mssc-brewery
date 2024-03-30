package haidarspringframework.msscbrewery.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBeerReqDTO {
    @NotBlank
    @NotNull
    @Length(min = 3, max = 255)
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;
}
