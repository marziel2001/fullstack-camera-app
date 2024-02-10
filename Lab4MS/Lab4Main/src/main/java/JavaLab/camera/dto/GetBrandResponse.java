package JavaLab.camera.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetBrandResponse {

    private UUID uuid;

    private String name;

    private Integer yearOfEst;

    private String country;

    private Double brandValueDollars;

}
