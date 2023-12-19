package edu.unifaa.desafio2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unifaa.desafio2.model.AddressModel;
import edu.unifaa.desafio2.model.exceptions.ResourceBadRequestException;
import edu.unifaa.desafio2.model.exceptions.ResourceNotFoundException;
import edu.unifaa.desafio2.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressModel add(AddressModel address){
        return addressRepository.save(address);
    }

    public AddressModel getById(Long id){
        Optional<AddressModel> result = addressRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceNotFoundException("Não existe um endereço com o ID: " + id);
        }
        return result.get();
    }

    public List<AddressModel> getAll(){
        return addressRepository.findAll();
    }

    public AddressModel update(Long id, AddressModel address){
        Optional<AddressModel> result = addressRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um endereço com o ID: " + id);
        }else{
            address.setId(id);
            return addressRepository.save(address);
        }
    }

    public void delete(Long id){
        Optional<AddressModel> result = addressRepository.findById(id);
        if(result.isEmpty()){
            throw new ResourceBadRequestException("Não existe um endereço com o ID: " + id);
        }else{
            addressRepository.deleteById(id);
        }
    }
}
