package JavaLab.camera.service.api;

import JavaLab.camera.entity.Brand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    List<Brand> listAll();

    Optional<Brand> find(UUID id);

    void create(Brand brand);

    void delete(UUID id);
    void delete(String name);

    void updateBrand(Brand newBrand);
}
