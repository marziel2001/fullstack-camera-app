package JavaLab.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
