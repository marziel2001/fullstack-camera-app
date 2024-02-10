package JavaLab.model.repository;

import JavaLab.brand.entity.Brand;
import JavaLab.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {

    Optional<Model> findByUuid(UUID Uuid);

    List<Model> findAllByBrand(Brand brand);

    List<Model> findAll();
}
