package haidarspringframework.msscbrewery.web.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private UUID id;
    private String name;
}
