package edu.unifaa.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.desafio2.model.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    
}
