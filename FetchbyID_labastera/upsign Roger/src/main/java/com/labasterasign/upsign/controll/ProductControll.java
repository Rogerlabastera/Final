package com.labasterasign.upsign.controll;

import com.labasterasign.upsign.model.Product;
import com.labasterasign.upsign.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductControll {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/getProductByTitle")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productRepository.findByProduct(title);
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam String id) {
        return productRepository.findByid(id);
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product successfully added.";
    }
}
