package edu.unifaa.desafio2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.desafio2.model.CategoryModel;
import edu.unifaa.desafio2.model.exceptions.ResourceBadRequestException;
import edu.unifaa.desafio2.model.exceptions.ResourceNotFoundException;
import edu.unifaa.desafio2.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryModel add(CategoryModel category){
        return categoryRepository.save(category);
    }

    public CategoryModel getById(Long id){
        Optional<CategoryModel> result = categoryRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceNotFoundException("Não existe uma categoria com o ID: " + id);
        }
        return result.get();
    }

    public List<CategoryModel> getAll(){
        return categoryRepository.findAll();
    }

    public CategoryModel update(Long id, CategoryModel category){
        Optional<CategoryModel> result = categoryRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe uma categoria com o ID: " + id);
        }else{
            category.setId(id);
            return categoryRepository.save(category);
        }
    }

    public void delete(Long id){
        Optional<CategoryModel> result = categoryRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe uma categoria com o ID: " + id);
        }else{
            categoryRepository.deleteById(id);
        }
    }
}
