package JavaLab.camera.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetModelsResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Model {

        private UUID id;

        private String name;

    }

    private List<Model> models;

}
