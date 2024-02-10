package JavaLab.camera.dto;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PutModelRequest {

    private String name;

    private Double price;

    private Integer announceYear;

    private UUID brand;

}
