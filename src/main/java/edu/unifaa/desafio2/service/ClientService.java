package edu.unifaa.desafio2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.desafio2.model.ClientModel;
import edu.unifaa.desafio2.model.exceptions.ResourceBadRequestException;
import edu.unifaa.desafio2.model.exceptions.ResourceNotFoundException;
import edu.unifaa.desafio2.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientModel add(ClientModel client){
        return clientRepository.save(client);
    }

    public ClientModel getById(Long id){
        Optional<ClientModel> result = clientRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceNotFoundException("Não existe um cliente com o ID: " + id);
        }
        return result.get();
    }

    public List<ClientModel> getAll(){
        return clientRepository.findAll();
    }

    public ClientModel update(Long id, ClientModel client){
        Optional<ClientModel> result = clientRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um cliente com o ID: " + id);
        }else{
            client.setId(id);
            return clientRepository.save(client);
        }
    }

    public void delete(Long id){
        Optional<ClientModel> result = clientRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um cliente com o ID: " + id);
        }else{
            clientRepository.deleteById(id);
        }
    }
}
