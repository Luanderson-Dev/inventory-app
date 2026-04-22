package br.dev.luanderson.inventoryapp.controller;

import br.dev.luanderson.inventoryapp.entities.Product;
import br.dev.luanderson.inventoryapp.services.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Product add(@RequestParam String name, @RequestParam int quantity) {
        return service.addProduct(name, quantity);
    }

    @PostMapping("/remove")
    public Product remove(@RequestParam String name, @RequestParam int quantity) {
        return service.removeStock(name, quantity);
    }

    @GetMapping("/{name}")
    public Product get(@PathVariable String name) {
        return service.getProduct(name);
    }

    @GetMapping()
    public List<Product> getAll() {
        return service.getAllProducts();
    }
}