package JavaLab.brand.initialize;

import JavaLab.brand.entity.Brand;
import JavaLab.brand.service.api.BrandService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final BrandService brandService;
    @Autowired
    public InitializeData(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Brand sony = Brand.builder()
            .uuid(UUID.fromString("94c2b18d-9218-476e-8d66-5a2543ee6068"))
            .name("Sony")
            .country("Japan")
            .brandValueDollars(10800000000.00)
            .yearOfEst(1946)
            .build();

        Brand nikon = Brand.builder()
            .uuid(UUID.fromString("91d92bfc-a095-498d-926d-d7199ae2294f"))
            .name("Nikon")
            .country("Japan")
            .brandValueDollars(3450000000.00)
            .yearOfEst(1917)
            .build();

        brandService.save(nikon);
        brandService.save(sony);
    }
}
