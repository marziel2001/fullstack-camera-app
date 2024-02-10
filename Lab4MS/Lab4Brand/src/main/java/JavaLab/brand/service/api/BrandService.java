package JavaLab.brand.service.api;

import JavaLab.brand.entity.Brand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> find(UUID id);

    void create(Brand brand);

    void save(Brand brand);

    void delete(UUID id);

    void updateBrand(Brand newBrand);
}
