package com.vti.product_api.service;

import com.vti.product_api.ProductApiApplication;
import com.vti.product_api.model.Product;
import com.vti.product_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product insert (Product product) {
        return productRepository.save(product);
    }

    public List<Product> insertMulti (List<Product> productList) {
        return productRepository.saveAll(productList);
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public int delete (Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return 1;
        }
        return 0;
    }
    public Product update (Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()) {
//            Product p = optionalProduct.get();
            return productRepository.save(product);
        }
        return null;
    }
}
