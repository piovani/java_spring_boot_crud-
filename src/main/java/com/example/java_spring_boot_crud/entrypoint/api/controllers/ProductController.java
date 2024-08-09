package com.example.java_spring_boot_crud.entrypoint.api.controllers;

import com.example.java_spring_boot_crud.core.common.dto.ProductRecordDto;
import com.example.java_spring_boot_crud.dataprovider.database.entity.ProductEntity;
import com.example.java_spring_boot_crud.dataprovider.database.repositores.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productRepository.findAllByActiveTrue();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new ProductEntity();
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = product.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productEntity = product.get();
        productEntity.disable();
        productRepository.save(productEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }
}
