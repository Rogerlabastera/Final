package com.labasterasign.upsign.repository;

import com.labasterasign.upsign.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByProduct(String product);

    Product findByid(String id);
}
