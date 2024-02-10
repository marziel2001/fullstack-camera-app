package JavaLab.camera.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PatchModelRequest {

    private String name;

    private Double price;

    private Integer announceYear;

}
