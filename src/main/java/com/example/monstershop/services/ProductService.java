package com.example.monstershop.services;

import com.example.monstershop.dtos.product.ProductMapper;
import com.example.monstershop.dtos.product.ProductRequest;
import com.example.monstershop.dtos.product.ProductResponse;
import com.example.monstershop.models.Product;
import com.example.monstershop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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

//    public Product updateProduct (Long id, Product updateProduct) {
//        Product existingProduct = productRepository.findById(id).orElse(null);
//        existingProduct.setName(updateProduct.getName());
//        existingProduct.setPrice(updateProduct.getPrice());
//        existingProduct.setImageUrl(updateProduct.getImageUrl());
//        existingProduct.setRating(updateProduct.getRating());
//        existingProduct.setReviewCount(updateProduct.getReviewCount());
//        existingProduct.setFeatured(updateProduct.getFeatured());
//    }
//
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
}