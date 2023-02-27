package com.arpit.studentPortal.service;

import com.arpit.studentPortal.model.Address;
import com.arpit.studentPortal.repository.AddressRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
    public class AddressService {
        @Autowired
        private AddressRepository addressRepository;

        public Address createAddress(Address address) {
            return addressRepository.save(address);
        }

        public Address getAddressById(String id) {
            return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address" + "id not found"));
        }

        public List<Address> getAllAddresses() {
            return addressRepository.findAll();
        }

        public Address updateAddressById(String id, Address address) {
            Address existingAddress = getAddressById(id);
            existingAddress.setLandmark(address.getLandmark());
            existingAddress.setZipcode(address.getZipcode());
            existingAddress.setDistrict(address.getDistrict());
            existingAddress.setState(address.getState());
            existingAddress.setCountry(address.getCountry());
            return addressRepository.save(existingAddress);
        }

        public void deleteAddressById(String id) {
            Address address = getAddressById(id);
            addressRepository.delete(address);
        }
    }

