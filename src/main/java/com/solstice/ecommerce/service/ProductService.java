package com.solstice.ecommerce.service;

import com.solstice.ecommerce.model.Product;
import com.solstice.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {

        productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id) {

        return productRepository.findById(id);
    }

    public void updateProduct(Long id, Product product) {

        productRepository.save(product);
    }

    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }
}
