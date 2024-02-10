package JavaLab.brand.entity;

import JavaLab.model.entity.Model;
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

    @ToString.Exclude
    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Model> models;

}
