package JavaLab.brand.service.impl;

import JavaLab.brand.entity.Brand;
import JavaLab.brand.event.repository.api.BrandEventRepository;
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

    private final BrandEventRepository eventRepository;

    @Autowired
    public BrandDefaultService(BrandRepository repository, BrandEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Brand> find(UUID id) {
        return repository.findById(id);
    }


    @Override
    public void create(Brand brand) {
        repository.save(brand);
        eventRepository.create(brand);
    }

    @Override
    public void save(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
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
