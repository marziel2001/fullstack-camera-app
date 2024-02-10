package JavaLab.camera.service.impl;

import JavaLab.camera.entity.Brand;
import JavaLab.camera.entity.Model;
import JavaLab.camera.repository.BrandRepository;
import JavaLab.camera.repository.ModelRepository;
import JavaLab.camera.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModelDefaultService implements ModelService {

    private final ModelRepository repository;

    private final BrandRepository brandRepository;

    @Autowired
    public ModelDefaultService(ModelRepository repository, BrandRepository brandRepository) {
        this.repository = repository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Model> find(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Optional<Model> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Model> findAllByBrand(String name) {
        return repository.findAllByBrand_Name(name);
    }

    @Override
    public Optional<List<Model>> findAllByBrand(UUID BrandId) {
        return brandRepository.findById(BrandId)
            .map(repository::findAllByBrand);
    }

    @Override
    public Optional<Model> findById(UUID uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public List<Model> listAll() {
        return repository.findAll();
    }

    @Override
    public void addModelToBrand(String brand, Model model)
    {
        Optional<Brand> b = brandRepository.findAllByName(brand);

        if(b.isPresent()) {
            model.setBrand(b.get());
            repository.save(model);
        }
        else {
            System.out.println("Brand does not exist in database");
        }
    }

    @Override
    public void deleteModel(String brand, String model) {
        Optional<Brand> b = brandRepository.findAllByName(brand);
        Optional<Model> m = repository.findAllByName(model);

        if(b.isPresent()) {
            if(m.isPresent()) {
                repository.delete(m.get());
            }
            else {
                System.out.println("model not found in database");
            }
        }
        else {
            System.out.println("Brand does not exist in database");
        }
    }

    @Override
    public void deleteModel(UUID uuid) {
        repository.findById(uuid).ifPresent(repository::delete);
    }

    @Override
    public void create(Model model) {
        repository.save(model);
    }

    @Override
    public void updateModel(Model newModel) {
        UUID id = newModel.getUuid();

        Optional<Model> tmpOldModel = repository.findById(id);

        if(tmpOldModel.isPresent()) {
            Model oldModel = tmpOldModel.get();

            oldModel.setName(newModel.getName());
            oldModel.setPrice(newModel.getPrice());
            oldModel.setAnnounceYear(newModel.getAnnounceYear());

            repository.save(oldModel);

        } else {
            System.out.println("Model not found");
        }
    }
}
