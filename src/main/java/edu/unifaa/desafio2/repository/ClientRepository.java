package edu.unifaa.desafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.desafio2.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    
}
