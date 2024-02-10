package JavaLab.brand.event.repository.api;

import JavaLab.brand.dto.PutBrandRequest;
import JavaLab.brand.entity.Brand;

import java.util.UUID;

public interface BrandEventRepository {

    void delete(UUID id);
    void create(Brand brand);
}
