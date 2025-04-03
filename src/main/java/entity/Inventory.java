package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private int materialId;

    @Column(name = "material_category", length = 100)
    private String materialCategory;

    @Column(name = "material_name", length = 100)
    private String materialName;

    @Column(name = "material_stock")
    private int materialStock;

    @Column(name = "material_price")
    private float materialPrice;
}
