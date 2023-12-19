package edu.unifaa.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.desafio2.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    
}
