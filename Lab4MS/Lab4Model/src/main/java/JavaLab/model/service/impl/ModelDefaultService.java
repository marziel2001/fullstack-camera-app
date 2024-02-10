package JavaLab.model.service.impl;

import JavaLab.brand.entity.Brand;
import JavaLab.brand.repository.BrandRepository;
import JavaLab.model.entity.Model;
import JavaLab.model.repository.ModelRepository;
import JavaLab.model.service.api.ModelService;
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
    public Optional<Model> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<List<Model>> findAllByBrand(UUID BrandId) {
        return brandRepository.findById(BrandId)
            .map(repository::findAllByBrand);
    }

    @Override
    public List<Model> findAll() {
        return repository.findAll();
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
    public void update(Model newModel) {
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
