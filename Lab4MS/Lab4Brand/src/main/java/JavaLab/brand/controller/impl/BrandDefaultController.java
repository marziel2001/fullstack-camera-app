package JavaLab.brand.controller.impl;

import JavaLab.brand.dto.GetBrandsResponse;
import JavaLab.brand.dto.PatchBrandRequest;
import JavaLab.brand.entity.Brand;
import JavaLab.brand.function.BrandToResponseFunction;
import JavaLab.brand.function.BrandsToResponseFunction;
import JavaLab.brand.function.PutRequestToBrandFunction;
import JavaLab.brand.function.UpdateBrandWithRequestFunction;
import JavaLab.brand.service.api.BrandService;
import JavaLab.brand.controller.api.BrandController;
import JavaLab.brand.dto.GetBrandResponse;
import JavaLab.brand.dto.PutBrandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class BrandDefaultController implements BrandController {

    private final BrandService service;

    private final BrandToResponseFunction brandToResponse;

    private final BrandsToResponseFunction brandsToResponse;

    private final PutRequestToBrandFunction putRequestToBrand;

    private final UpdateBrandWithRequestFunction updateBrandWithRequest;

    @Autowired
    public BrandDefaultController(
        BrandService service,
        BrandToResponseFunction brandToResponse,
        BrandsToResponseFunction brandsToResponse,
        PutRequestToBrandFunction putRequestToBrand,
        UpdateBrandWithRequestFunction updateBrandWithRequest
    ) {
        this.service = service;
        this.brandToResponse = brandToResponse;
        this.brandsToResponse = brandsToResponse;
        this.putRequestToBrand = putRequestToBrand;
        this.updateBrandWithRequest = updateBrandWithRequest;
    }

    @Override
    public GetBrandsResponse getBrands() {

        List<Brand> Brands = service.findAll();

        if(Brands.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        else {
            return brandsToResponse.apply(service.findAll());
        }
    }

    @Override
    public GetBrandResponse getBrand(UUID id) {
        return service.find(id)
            .map(brandToResponse)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putBrand(PutBrandRequest request) {
        service.create(putRequestToBrand.apply(request));
    }

    @Override
    public void patchBrand(UUID id, PatchBrandRequest request) {
        service.find(id)
            .ifPresentOrElse(
                brand -> service.updateBrand(updateBrandWithRequest.apply(brand, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
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
}
