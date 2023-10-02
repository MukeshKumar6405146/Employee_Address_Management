package com.geekster.Employee_Address.service;

import com.geekster.Employee_Address.model.Address;
import com.geekster.Employee_Address.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    //GET /addresses - get all addresses
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    //GET /addresses/{id} - get an address by id
    public Optional<Address> getById(Long id) {
        return addressRepo.findById(id);
    }

    //POST /addresses - create a new address
    public String save(Address address) {
        Address saved = addressRepo.save(address);
        if(saved != null) return "Address Saved";
        return "Address Not Saved";
    }

    //DELETE /addresses/{id} - delete an address by id
    public String deleteById(Long id) {
        addressRepo.deleteById(id);
        if(!addressRepo.existsById(id)) return "Address with id : " + id + " has been deleted";
        return "Address with id : " + id + " has not been deleted";
    }

    //PUT /addresses/{id} - update an address by id
    public String updateAddress(Address address, Long id) {
        address.setId(id);
        Address updated = addressRepo.save(address);
        if(updated != null) return "Address with id " + id + " updated";
        return "Address with id " + id + " not updated";
    }
}