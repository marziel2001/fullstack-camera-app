package JavaLab.brand.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "brands")
public class Brand implements Serializable {

    @Id
    private UUID uuid;

    private String name;

    @Column(name = "year_of_est")
    private Integer yearOfEst;

    private String country;

    @Column(name = "brand_value_dollars")
    private Double brandValueDollars;

}
