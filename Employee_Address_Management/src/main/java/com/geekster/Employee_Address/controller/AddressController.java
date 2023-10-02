package com.geekster.Employee_Address.controller;

import com.geekster.Employee_Address.model.Address;
import com.geekster.Employee_Address.model.Employee;
import com.geekster.Employee_Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    //GET
    // /addresses - get all addresses
    @GetMapping(value = "/all")
    public List<Address> getAddresses(){
        return addressService.getAll();
    }

    //GET /addresses/{id} - get an address by id
    @GetMapping(value = "/{id}")
    public Optional<Address> getAddress(@PathVariable Long id){
        return addressService.getById(id);
    }

    //POST
    // /addresses - create a new address
    @PostMapping(value = "/insert")
    public String addEmployee(@RequestBody Address address) {
        return addressService.save(address);
    }

    //PUT
    // /addresses/{id} - update an address by id
    @PutMapping(value = "/{id}")
    public String updateAddress(@RequestBody Address address, @PathVariable Long id) {
        return addressService.updateAddress(address, id);
    }

    //DELETE
    // /addresses/{id} - delete an address by id
    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return addressService.deleteById(id);
    }
}
