package JavaLab.model.entity;

import JavaLab.brand.entity.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "models")
public class Model {

    @Id
    private UUID uuid;

    @EqualsAndHashCode.Exclude // to avoid circular dependencies
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;

    private String name;

    private Double price;

    @Column(name = "announce_year")
    private Integer announceYear;
}
