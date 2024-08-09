package com.example.java_spring_boot_crud.dataprovider.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "TB_PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;

    private String name;

    private BigDecimal value;


    @Value("true")
    private Boolean active;

    public void disable() {
        this.active = false;
    }
}
