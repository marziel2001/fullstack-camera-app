package JavaLab.brand.service.impl;

import JavaLab.brand.entity.Brand;
import JavaLab.brand.repository.BrandRepository;
import JavaLab.brand.service.api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandDefaultService implements BrandService {

    private final BrandRepository repository;

    @Autowired
    public BrandDefaultService(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Brand> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void create(UUID id) {
        repository.save(Brand.builder().uuid(id).build());
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
