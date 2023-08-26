package com.example.productsjavapostgres.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productsjavapostgres.dtos.ProductRecordDTO;
import com.example.productsjavapostgres.models.ProductModel;
import com.example.productsjavapostgres.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductModel saveProduct(ProductRecordDTO productRecordDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        return productRepository.save(productModel);
    }

    public List<ProductModel> getProducts() {
        List<ProductModel> productsList = productRepository.findAll();
        return productsList;
    }

    public Optional<ProductModel> getProductById(Long id) {
        Optional<ProductModel> product = productRepository.findById(id);
        return product;
    }

    public ProductModel updateProductById(Long id, ProductRecordDTO productRecordDTO) {
        Optional<ProductModel> product = productRepository.findById(id);
        var productModel = product.get();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        return productRepository.save(productModel);
    }

    public Optional<ProductModel> deleteProductById(Long id) {
        Optional<ProductModel> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return product;
    }



}
