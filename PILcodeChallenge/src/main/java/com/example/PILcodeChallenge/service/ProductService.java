package com.example.PILcodeChallenge.service;

import com.example.PILcodeChallenge.exceptions.ProductNotFoundException;
import com.example.PILcodeChallenge.models.Product;
import com.example.PILcodeChallenge.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieve a list of all products.
     * @return List of products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    /**
     * Retrieve a specific Product by its ID.
     * @param id The ID of the Product to retrieve
     * @return The retrieved Product
     * @throws EntityNotFoundException if the Product with the given ID is not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    /**
     * Create a new Product.
     * @param Product The Product object to be created
     * @return The created Product
     */
    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    /**
     * Update an existing Product.
     * @param id The ID of the Product to be updated
     * @param productDetails The updated Product object
     * @return The updated Product
     * @throws EntityNotFoundException if the Product with the given ID is not found
     */
    public Product updateProduct(Long id, Product productDetails) {
        Product Product = getProductById(id);
        Product.setProduct_image(productDetails.getProduct_image());
        Product.setProduct_name(productDetails.getProduct_name());
        Product.setStock(productDetails.getStock());
        return productRepository.save(Product);
    }

    /**
     * Delete a Product by its ID.
     * @param id The ID of the Product to be deleted
     * @throws EntityNotFoundException if the Product with the given ID is not found
     */
    public void deleteProduct(Long id) {
        Product Product = getProductById(id);
        productRepository.delete(Product);
    }

    public List<Product> createProductFromList(List<Product> products) {
        for (Product product : products) {
            productRepository.save(product);
        }
        return products;
    }
}
