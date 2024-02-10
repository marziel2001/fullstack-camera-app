package JavaLab.camera.controller.api;

import JavaLab.camera.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BrandController {

    @GetMapping("/api/brands")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandsResponse getBrands();

    @GetMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandResponse getBrand(
        @PathVariable("id")
        UUID id
    );

    @DeleteMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBrand(
        @PathVariable("id")
        UUID id
    );

    @PutMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putBrand(
        @PathVariable("id")
        UUID id,
        @RequestBody
        PutBrandRequest request
    );

    @PatchMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchBrand(
        @PathVariable("id")
        UUID id,
        @RequestBody
        PatchBrandRequest request
    );

}
