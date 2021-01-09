package com.spring.mvc.psi.repository;

import com.spring.mvc.psi.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
    
}
