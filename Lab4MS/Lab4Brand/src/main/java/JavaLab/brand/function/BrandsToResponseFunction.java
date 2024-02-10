package JavaLab.brand.function;

import JavaLab.brand.dto.GetBrandsResponse;
import JavaLab.brand.entity.Brand;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BrandsToResponseFunction implements Function<List<Brand>, GetBrandsResponse> {

    public GetBrandsResponse apply(List<Brand> entities) {
        return GetBrandsResponse.builder()
            .brands(entities.stream()
                .map(brand -> GetBrandsResponse.Brand.builder()
                    .id(brand.getUuid())
                    .name(brand.getName())
                    .build())
                .toList())
            .build();
    }
}
