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

import edu.unifaa.desafio2.model.AddressModel;
import edu.unifaa.desafio2.service.AddressService;

@RestController
@RequestMapping("/api/address")
@CrossOrigin("*")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressModel> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressModel getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping
    public AddressModel add(@RequestBody AddressModel address){
        return addressService.add(address);
    }

    @PutMapping("/{id}")
    public AddressModel update(@PathVariable Long id, @RequestBody AddressModel address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        addressService.delete(id);
    }
}
