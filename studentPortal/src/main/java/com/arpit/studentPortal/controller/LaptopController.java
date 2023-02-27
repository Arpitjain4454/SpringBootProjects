package com.arpit.studentPortal.controller;

import com.arpit.studentPortal.model.Laptop;
import com.arpit.studentPortal.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable String id) {
        Laptop laptop = laptopService.getLaptopById(id);
        if (laptop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptop);
    }

    @PostMapping("")
    public ResponseEntity<Laptop> createLaptop(@RequestBody @Valid Laptop laptop) {
        laptop = laptopService.createLaptop(laptop);
        return ResponseEntity.ok(laptop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable String id, @RequestBody @Valid Laptop laptop) {
        laptop = laptopService.updateLaptop(id, laptop);
        if (laptop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable String id) {
        boolean deleted = laptopService.deleteLaptop(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
