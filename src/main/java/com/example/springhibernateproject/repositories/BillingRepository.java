package com.example.springhibernateproject.repositories;

import com.example.springhibernateproject.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingInfo, Long> {
}
