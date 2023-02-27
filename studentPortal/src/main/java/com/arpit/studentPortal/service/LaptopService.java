package com.arpit.studentPortal.service;

import com.arpit.studentPortal.repository.LaptopRepository;
import com.arpit.studentPortal.model.Laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop getLaptopById(String id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(String id, Laptop laptop) {
        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
        if (existingLaptop == null) {
            return null;
        }
        laptop.setId(existingLaptop.getId());
        return laptopRepository.save(laptop);
    }

    public boolean deleteLaptop(String id) {
        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
        if (existingLaptop == null) {
            return false;
        }
        laptopRepository.delete(existingLaptop);
        return true;
    }
}


