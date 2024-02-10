package JavaLab.model.controller.impl;

import JavaLab.model.controller.api.ModelController;
import JavaLab.model.dto.GetModelResponse;
import JavaLab.model.dto.GetModelsResponse;
import JavaLab.model.dto.PatchModelRequest;
import JavaLab.model.dto.PutModelRequest;
import JavaLab.model.entity.Model;
import JavaLab.model.function.ModelToResponseFunction;
import JavaLab.model.function.ModelsToResponseFunction;
import JavaLab.model.function.PutRequestToModelFunction;
import JavaLab.model.function.UpdateModelWithRequestFunction;
import JavaLab.model.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class ModelDefaultController implements ModelController {

    private final ModelService service;

    private final ModelsToResponseFunction modelsToResponse;

    private final ModelToResponseFunction modelToResponse;

    private final PutRequestToModelFunction putRequestToModel;

    private final UpdateModelWithRequestFunction updateModelWithRequest;

    @Autowired
    public ModelDefaultController(
        ModelService service,
        ModelsToResponseFunction modelsToResponse,
        ModelToResponseFunction modelToResponse,
        PutRequestToModelFunction putRequestToModel,
        UpdateModelWithRequestFunction updateModelWithRequest
    ) {
        this.service = service;
        this.modelsToResponse = modelsToResponse;
        this.modelToResponse = modelToResponse;
        this.putRequestToModel = putRequestToModel;
        this.updateModelWithRequest = updateModelWithRequest;
    }

    @Override
    public GetModelsResponse getModels() {

        List<Model> Models = service.findAll();

        if(Models.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            return modelsToResponse.apply(service.findAll());
        }
    }

    @Override
    public GetModelResponse getModel(UUID id) {
        return service.find(id)
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
    public void putModel(PutModelRequest request) {
        service.create(putRequestToModel.apply(request));
    }

    @Override
    public void patchModel(UUID id, PatchModelRequest request) {
        service.find(id)
            .ifPresentOrElse(
                model -> service.update(updateModelWithRequest.apply(model, request)),
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
