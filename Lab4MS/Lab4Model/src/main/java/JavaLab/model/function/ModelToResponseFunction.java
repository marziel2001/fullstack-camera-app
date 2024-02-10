package JavaLab.model.function;

import JavaLab.model.dto.GetModelResponse;
import JavaLab.model.entity.Model;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ModelToResponseFunction implements Function<Model, GetModelResponse> {

    public GetModelResponse apply(Model entity) {
        return GetModelResponse.builder()
            .uuid(entity.getUuid())
            .name(entity.getName())
            .price(entity.getPrice())
            .announceYear(entity.getAnnounceYear())
            .build();
    }
}
