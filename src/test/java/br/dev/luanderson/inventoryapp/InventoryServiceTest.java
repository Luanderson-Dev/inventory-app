package br.dev.luanderson.inventoryapp;

import br.dev.luanderson.inventoryapp.entities.Product;
import br.dev.luanderson.inventoryapp.services.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class InventoryServiceTest {
    @Autowired
    private InventoryService service;

    @Test
    void shouldNotAllowNegativeStock() {
        service.addProduct("Notebook", 10);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.removeStock("Notebook", 20);
        });

        assertEquals("Insufficient stock", exception.getMessage());
    }

    @Test
    void shouldPersistData() {
        Product product = service.addProduct("Mouse", 5);
        Product found = service.getProduct("Mouse");

        assertEquals(product.getId(), found.getId());
    }
}
