package com.nakoulmakim.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nakoulmakim.productservice.dto.ProductRequest;
import com.nakoulmakim.productservice.dto.ProductResponse;
import com.nakoulmakim.productservice.model.Product;
import com.nakoulmakim.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @SuppressWarnings("null")
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();
        
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    /**
     * @return
     */
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
    }
}
