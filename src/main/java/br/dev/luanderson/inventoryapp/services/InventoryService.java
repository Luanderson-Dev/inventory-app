package br.dev.luanderson.inventoryapp.services;

import br.dev.luanderson.inventoryapp.entities.Product;
import br.dev.luanderson.inventoryapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductRepository repository;

    public Product addProduct(String name, int quantity) {
        return repository.save(new Product(name, quantity));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product removeStock(String name, int quantity) {
        Product product = repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        product.setQuantity(product.getQuantity() - quantity);
        return repository.save(product);
    }

    public Product getProduct(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}