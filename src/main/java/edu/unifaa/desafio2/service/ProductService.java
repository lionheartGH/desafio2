package edu.unifaa.desafio2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.desafio2.model.ProductModel;
import edu.unifaa.desafio2.model.exceptions.ResourceBadRequestException;
import edu.unifaa.desafio2.model.exceptions.ResourceNotFoundException;
import edu.unifaa.desafio2.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductModel add(ProductModel product){
        return productRepository.save(product);
    }

    public ProductModel getById(Long id){
        Optional<ProductModel> result = productRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceNotFoundException("Não existe um produto com o ID: " + id);
        }
        return result.get();
    }

    public List<ProductModel> getAll(){
        return productRepository.findAll();
    }

    public ProductModel update(Long id, ProductModel product){
        Optional<ProductModel> result = productRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um produto com o ID: " + id);
        }else{
            product.setId(id);
            return productRepository.save(product);
        }
    }

    public void delete(Long id){
        Optional<ProductModel> result = productRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um produto com o ID: " + id);
        }else{
            productRepository.deleteById(id);
        }
    }
}
