package com.example.PILcodeChallenge.controllers;

import com.example.PILcodeChallenge.models.Product;
import com.example.PILcodeChallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Retrieve a list of all products.
     * @return ResponseEntity containing a list of products and HttpStatus.OK
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /**
     * Retrieve a specific Product by its ID.
     * @param id The ID of the Product to retrieve
     * @return ResponseEntity containing the retrieved Product and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product Product = productService.getProductById(id);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }

    /**
     * Create a new Product.
     * @param Product The Product object to be created
     * @return ResponseEntity containing the created Product and HttpStatus.CREATED
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
        Product createdProduct = productService.createProduct(Product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /**
     * Create a new Product from a list.
     * @param Products list The Product object to be created
     * @return ResponseEntity containing the created Product and HttpStatus.CREATED
     */
    @PostMapping("/fromList")
    public ResponseEntity<List<Product>> createProductFromList(@RequestBody List<Product> Products) {
        for (Product product : Products) {
            Product createdProduct = productService.createProduct(product);
        }
        return new ResponseEntity<>(Products, HttpStatus.OK);
    }

    /**
     * Update an existing Product.
     * @param id The ID of the Product to be updated
     * @param Product The updated Product object
     * @return ResponseEntity containing the updated Product and HttpStatus.OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product Product) {
        Product updatedProduct = productService.updateProduct(id, Product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /**
     * Delete a Product by its ID.
     * @param id The ID of the Product to be deleted
     * @return ResponseEntity with HttpStatus.NO_CONTENT
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
