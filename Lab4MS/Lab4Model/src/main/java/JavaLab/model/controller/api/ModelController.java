package JavaLab.model.controller.api;

import JavaLab.model.dto.GetModelResponse;
import JavaLab.model.dto.GetModelsResponse;
import JavaLab.model.dto.PatchModelRequest;
import JavaLab.model.dto.PutModelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ModelController {

    @GetMapping("/api/models")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelsResponse getModels();

    @GetMapping("/api/models/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelResponse getModel(
        @PathVariable("id")
        UUID id
    );

    @GetMapping("/api/brands/{id}/models")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetModelsResponse getBrandsModels(
        @PathVariable("id")
        UUID id
    );

    @PutMapping("/api/models")
    @ResponseStatus(HttpStatus.CREATED)
        void putModel(
            @RequestBody
            PutModelRequest request
    );

    @PatchMapping("/api/models/{id}")
    @ResponseStatus(HttpStatus.OK)
        void patchModel(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchModelRequest request
    );

    @DeleteMapping("/api/models/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteModel(
        @PathVariable("id")
        UUID id
    );

}
