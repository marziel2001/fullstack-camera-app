package JavaLab.brand.event.repository.rest;

import JavaLab.brand.entity.Brand;
import JavaLab.brand.event.repository.api.BrandEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class BrandEventRestRepository implements BrandEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public BrandEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/brands/{id}", id);
    }

    @Override
    public void create(Brand brand) {
        restTemplate.put("/api/brands/"+ brand.getUuid() +"/models", brand.getUuid());
    }
}
