package com.example.productsjavapostgres.controllers;

import com.example.productsjavapostgres.dtos.ProductRecordDTO;
import com.example.productsjavapostgres.models.ProductModel;
import com.example.productsjavapostgres.services.ProductService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/get-products")
    public ResponseEntity<List<ProductModel>> getProducts() {
        List<ProductModel> productsList = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long id) {
        Optional<ProductModel> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/save-product")
    public ResponseEntity<ProductModel> saveProduct(@Valid @RequestBody ProductRecordDTO productRecordDTO) {
        ProductModel savedProduct = productService.saveProduct(productRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/update-product/{id}")
    public Object updateProductById(@PathVariable(value = "id") Long id,
            @RequestBody ProductRecordDTO productRecordDTO) {
        Optional<ProductModel> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        ProductModel updatedProduct = productService.updateProductById(id, productRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/delete-product/{id}")
    public Object deleteProductById(@PathVariable(value = "id") Long id) {
        Optional<ProductModel> product = productService.getProductById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted.");
    }

}
