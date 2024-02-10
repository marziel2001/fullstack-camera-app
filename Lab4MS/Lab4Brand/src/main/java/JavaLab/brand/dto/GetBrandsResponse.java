package JavaLab.brand.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetBrandsResponse {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class Brand {

        private UUID id;

        private String name;

    }

    private List<Brand> brands;

}
