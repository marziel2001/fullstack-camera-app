package JavaLab.brand.service.api;

import JavaLab.brand.entity.Brand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {


    Optional<Brand> find(UUID id);

    void create(Brand brand);

    void create(UUID id);

    void delete(UUID id);

}
