package edu.unifaa.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.desafio2.model.ProductModel;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
