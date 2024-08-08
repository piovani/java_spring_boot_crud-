package com.example.java_spring_boot_crud.dataprovider.database.repositores;

import com.example.java_spring_boot_crud.dataprovider.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
