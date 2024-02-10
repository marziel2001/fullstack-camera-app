package JavaLab.brand.controller.impl;

import JavaLab.brand.controller.api.BrandController;
import JavaLab.brand.entity.Brand;
import JavaLab.brand.service.api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class BrandDefaultController implements BrandController {

    private final BrandService service;

    @Autowired
    public BrandDefaultController(
        BrandService service
    ) {
        this.service = service;
    }

    @Override
    public void deleteBrand(UUID id) {
        service.find(id)
            .ifPresentOrElse(
                brand -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
    }

    @Override
    public void putBrand(UUID id) {
        service.create(id);
    }

}
