package JavaLab.brand.controller.api;

import JavaLab.brand.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BrandController {

    @DeleteMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBrand(
        @PathVariable("id")
        UUID id
    );

    @PutMapping("/api/brands/{id}/models")
    @ResponseStatus(HttpStatus.CREATED)
    void putBrand(
        @PathVariable("id")
        UUID id
    );


}
