package JavaLab.camera.function;

import JavaLab.camera.dto.PutModelRequest;
import JavaLab.camera.entity.Brand;
import JavaLab.camera.entity.Model;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutRequestToModelFunction implements BiFunction<UUID, PutModelRequest, Model> {
    public Model apply(UUID id, PutModelRequest request) {
        return Model.builder()
            .uuid(id)
            .brand(Brand.builder().uuid(request.getBrand()).build())
            .name(request.getName())
            .announceYear(request.getAnnounceYear())
            .price(request.getPrice())
            .build();
    }
}
