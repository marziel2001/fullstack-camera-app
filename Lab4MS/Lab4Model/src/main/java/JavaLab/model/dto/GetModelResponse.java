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
public class GetModelResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Brand {

        private UUID uuid;

        private String name;

    }

    private UUID uuid;

    private String name;

    private Double price;

    private Integer announceYear;

}