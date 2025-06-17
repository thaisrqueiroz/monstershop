package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductMapper;
import com.example.monstershop.dtos.product.ProductRequest;
import com.example.monstershop.dtos.product.ProductResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product newProduct = ProductMapper.dtoToEntity(productRequest);
        Product savedProduct = productRepository.save(newProduct);
        return ProductMapper.entityToDto(savedProduct);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found with id: " + id));
        existingProduct.setName(productRequest.name());
        existingProduct.setImageUrl(productRequest.imageUrl());
        existingProduct.setPrice(productRequest.price());
        existingProduct.setRating(productRequest.rating());
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.entityToDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}