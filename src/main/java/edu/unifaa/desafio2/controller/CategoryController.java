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

import edu.unifaa.desafio2.model.CategoryModel;
import edu.unifaa.desafio2.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryModel getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryModel add(@RequestBody CategoryModel category){
        return categoryService.add(category);
    }

    @PutMapping("/{id}")
    public CategoryModel update(@PathVariable Long id, @RequestBody CategoryModel category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
