package com.nakoulmakim.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nakoulmakim.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
