package JavaLab.camera.service.api;

import JavaLab.camera.entity.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {

    Optional<Model> find(String name);

    Optional<Model> find(UUID id);

    List<Model> findAllByBrand(String name);

    Optional<List<Model>> findAllByBrand(UUID uuid);

    Optional<Model> findById(UUID uuid);

    List<Model> listAll();

    void addModelToBrand(String brand, Model model);

    void deleteModel(String brand, String model);

    void deleteModel(UUID uuid);

    void create(Model model);

    void updateModel(Model newModel);
}
