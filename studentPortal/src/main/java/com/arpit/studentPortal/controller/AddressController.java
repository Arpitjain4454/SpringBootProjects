package com.arpit.studentPortal.controller;

import com.arpit.studentPortal.model.Address;
import com.arpit.studentPortal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable String id) {
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("/{id}")
    public Address updateAddressById(@PathVariable String id,@RequestBody Address address) {
        return addressService.updateAddressById(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable String id) {
        addressService.deleteAddressById(id);
    }
}

