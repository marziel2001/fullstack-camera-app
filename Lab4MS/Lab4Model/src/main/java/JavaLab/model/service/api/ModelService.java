package JavaLab.model.service.api;

import JavaLab.model.entity.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {

    Optional<Model> find(UUID id);

    Optional<List<Model>> findAllByBrand(UUID uuid);

    List<Model> findAll();

    void deleteModel(UUID uuid);

    void create(Model model);

    void update(Model newModel);

}
