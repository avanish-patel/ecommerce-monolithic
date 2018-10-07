package com.solstice.ecommerce.controller;

import com.solstice.ecommerce.model.Product;
import com.solstice.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();

    }

    @PostMapping()
    public void addProduct(@RequestBody Product product) {

        productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") long id) {

        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") long id, @RequestBody Product product) {

        productService.updateProduct(id, product);
        return "Product is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") long id) {

        productService.deleteProductById(id);

        return "Product is deleted.";
    }
}
