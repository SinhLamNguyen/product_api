package com.vti.product_api.controller;

import com.vti.product_api.model.Product;
import com.vti.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert (@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.insert(product));
    }

    @PostMapping("/insertMulti")
    public ResponseEntity<?> insertMulti (@RequestBody List<Product> productList) {
        return ResponseEntity.status(HttpStatus.OK).body(productService
                .insertMulti(productList));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete (@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
    }
    @PostMapping("/update")
    public ResponseEntity<Product> update (@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(product));
    }
}
