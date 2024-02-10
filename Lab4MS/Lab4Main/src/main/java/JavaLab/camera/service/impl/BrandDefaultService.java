package JavaLab.camera.service.impl;

import JavaLab.camera.entity.Brand;
import JavaLab.camera.repository.BrandRepository;
import JavaLab.camera.repository.ModelRepository;
import JavaLab.camera.service.api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandDefaultService implements BrandService {

    private final BrandRepository repository;

    private final ModelRepository modelRepository;

    @Autowired
    public BrandDefaultService(BrandRepository repository, ModelRepository modelRepository) {
        this.repository = repository;
        this.modelRepository = modelRepository;
    }


    @Override
    public List<Brand> listAll() {
        return repository.findAll();
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
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String name) {
        repository.findAllByName(name).ifPresentOrElse(repository::delete, () -> System.out.println("not found"));
    }

    @Override
    public void updateBrand(Brand newBrand) {
        UUID id = newBrand.getUuid();

        Optional<Brand> tmpOldBrand = repository.findById(id);

        if(tmpOldBrand.isPresent()) {
            Brand oldBrand = tmpOldBrand.get();

            oldBrand.setName(newBrand.getName());
            oldBrand.setYearOfEst(newBrand.getYearOfEst());
            oldBrand.setCountry(newBrand.getCountry());
            oldBrand.setBrandValueDollars(newBrand.getBrandValueDollars());

            repository.save(oldBrand);

        } else {
            System.out.println("Brand not found");
        }
    }
}
