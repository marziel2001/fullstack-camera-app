package JavaLab.camera.controller.impl;

import JavaLab.camera.controller.api.ModelController;
import JavaLab.camera.dto.GetModelResponse;
import JavaLab.camera.dto.GetModelsResponse;
import JavaLab.camera.dto.PatchModelRequest;
import JavaLab.camera.dto.PutModelRequest;
import JavaLab.camera.entity.Model;
import JavaLab.camera.function.ModelToResponseFunction;
import JavaLab.camera.function.ModelsToResponseFunction;
import JavaLab.camera.function.PutRequestToModelFunction;
import JavaLab.camera.function.UpdateModelWithRequestFunction;
import JavaLab.camera.service.api.BrandService;
import JavaLab.camera.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class ModelDefaultController implements ModelController {

    private final ModelService service;

    private final BrandService brandService;

    private final ModelsToResponseFunction modelsToResponse;

    private final ModelToResponseFunction modelToResponse;

    private final PutRequestToModelFunction putRequestToModel;

    private final UpdateModelWithRequestFunction updateModelWithRequest;

    @Autowired
    public ModelDefaultController(
        ModelService service,
        BrandService brandService, ModelsToResponseFunction modelsToResponse,
        ModelToResponseFunction modelToResponse,
        PutRequestToModelFunction putRequestToModel,
        UpdateModelWithRequestFunction updateModelWithRequest
    ) {
        this.service = service;
        this.brandService = brandService;
        this.modelsToResponse = modelsToResponse;
        this.modelToResponse = modelToResponse;
        this.putRequestToModel = putRequestToModel;
        this.updateModelWithRequest = updateModelWithRequest;
    }

    @Override
    public GetModelsResponse getModels() {

        List<Model> Models = service.listAll();

        if(Models.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            return modelsToResponse.apply(Models);
        }
    }

    @Override
    public GetModelResponse getModel(UUID id) {
        return service.findById(id)
            .map(modelToResponse)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetModelsResponse getBrandsModels(UUID id) {
        return service.findAllByBrand(id)
            .map(modelsToResponse)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putModel(UUID id, PutModelRequest request) {
        brandService.find(request.getBrand())
            .ifPresentOrElse(
                model -> service.create(putRequestToModel.apply(id, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
    }

    @Override
    public void patchModel(UUID id, PatchModelRequest request) {
        service.find(id)
            .ifPresentOrElse(
                model -> service.updateModel(updateModelWithRequest.apply(model, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
    }

    @Override
    public void deleteModel(UUID id) {
        service.find(id)
            .ifPresentOrElse(
                model -> service.deleteModel(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            );
    }
}
