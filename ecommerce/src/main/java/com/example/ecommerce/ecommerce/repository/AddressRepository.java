package com.example.ecommerce.ecommerce.repository;

import com.example.ecommerce.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
