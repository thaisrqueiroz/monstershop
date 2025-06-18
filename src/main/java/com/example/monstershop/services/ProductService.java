package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductMapper;
import com.example.monstershop.dtos.product.ProductRequest;
import com.example.monstershop.dtos.product.ProductResponse;
import com.example.monstershop.exceptions.ProductNotFoundException;
import com.example.monstershop.models.Product;
import com.example.monstershop.repositories.ProductRepository;
import com.example.monstershop.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.entityToDto(product);
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
        existingProduct.setPrice(productRequest.price());
        existingProduct.setImageUrl(productRequest.imageUrl());
        existingProduct.setRating(productRequest.rating());
        existingProduct.setFeatured(productRequest.featured());
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.entityToDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}