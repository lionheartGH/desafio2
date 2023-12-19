package edu.unifaa.desafio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifaa.desafio2.model.ProductModel;
import edu.unifaa.desafio2.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductModel getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public ProductModel add(@RequestBody ProductModel product){
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public ProductModel update(@PathVariable Long id, @RequestBody ProductModel product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}
