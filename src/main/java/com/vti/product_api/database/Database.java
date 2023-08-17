package com.vti.product_api.database;

import com.vti.product_api.model.Product;
import com.vti.product_api.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase (ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product sp1 = new Product();
                sp1.setId(1l);
                sp1.setName("Máy tính");
                sp1.setType("Đồ điện tử");
                sp1.setDesc("abcd");
                sp1.setPrice(20000000l);
                productRepository.save(sp1);

                Product sp2 = new Product();
                sp2.setId(2l);
                sp2.setName("Điện thoại");
                sp2.setType("Đồ điện tử");
                sp2.setDesc("abcdefgh");
                sp2.setPrice(10000000l);
                productRepository.save(sp2);
            }
        };
    }
}
