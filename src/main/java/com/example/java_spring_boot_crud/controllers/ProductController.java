package com.example.java_spring_boot_crud.controllers;

import com.example.java_spring_boot_crud.models.ProductModel;
import com.example.java_spring_boot_crud.repositores.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

//    @PostMapping
//    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
//        var productModel = new ProductModel();
//        BeanUtils.copyProperties(productRecordDto, productModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
//    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

//    @GetMapping(basePath + "/{id}")
//    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
//        Optional<ProductModel> product0 = productRepository.findById(id);
//        if(product0.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
//    }
//
//    @PutMapping(basePath + "/{id}")
//    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
//                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
//        Optional<ProductModel> product0 = productRepository.findById(id);
//        if (product0.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
//        }
//        var productModel = product0.get();
//        BeanUtils.copyProperties(productRecordDto, productModel);
//        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
//    }
//
//    @DeleteMapping(basePath + "/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable(value="id") UUID id) {
//        Optional<ProductModel> product0 = productRepository.findById(id);
//        if (product0.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
//        }
//        productRepository.delete(product0.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
//    }

}
