package JavaLab.camera.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PatchBrandRequest {

    private String name;

    private Integer yearOfEst;

    private String country;

    private Double brandValueDollars;

}
