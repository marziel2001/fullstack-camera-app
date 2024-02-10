package JavaLab.camera.repository;

import JavaLab.camera.entity.Brand;
import JavaLab.camera.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {

    List<Model> findAllByBrand_Name(String name);

    Optional<Model> findByUuid(UUID Uuid);

    List<Model> findAllByBrand(Brand brand);

    Optional<Model> findAllByName(String name);

    List<Model> findAll();
}
