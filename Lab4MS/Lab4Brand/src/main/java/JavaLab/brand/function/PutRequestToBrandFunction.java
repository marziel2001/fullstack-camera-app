package JavaLab.brand.function;

import JavaLab.brand.dto.PutBrandRequest;
import JavaLab.brand.entity.Brand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class PutRequestToBrandFunction implements Function<PutBrandRequest, Brand> {

    public Brand apply(PutBrandRequest request) {
        return Brand.builder()
            .uuid(UUID.randomUUID())
            .name(request.getName())
            .brandValueDollars(request.getBrandValueDollars())
            .country(request.getCountry())
            .yearOfEst(request.getYearOfEst())
            .build();
    }

}
