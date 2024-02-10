package JavaLab.brand.controller.api;

import JavaLab.brand.dto.GetBrandResponse;
import JavaLab.brand.dto.GetBrandsResponse;
import JavaLab.brand.dto.PatchBrandRequest;
import JavaLab.brand.dto.PutBrandRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BrandController {

    @GetMapping("api/brands")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandsResponse getBrands();

    @GetMapping("api/brands/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandResponse getBrand(
        @PathVariable("id")
        UUID id
    );

    @DeleteMapping("/api/brands/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBrand(
        @PathVariable("id") UUID id
    );

    @PutMapping("/api/brands")
    @ResponseStatus(HttpStatus.CREATED)
    void putBrand(
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
