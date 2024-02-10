package JavaLab.camera.function;

import JavaLab.camera.dto.GetModelResponse;
import JavaLab.camera.entity.Model;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ModelToResponseFunction implements Function<Model, GetModelResponse> {

    public GetModelResponse apply(Model entity) {
        return GetModelResponse.builder()
            .uuid(entity.getUuid())
            .name(entity.getName())
            .price(entity.getPrice())
            .announceDate(entity.getAnnounceYear())
            .build();
    }
}
