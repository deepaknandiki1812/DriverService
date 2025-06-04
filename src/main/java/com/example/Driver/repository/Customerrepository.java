package com.example.Driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Driver.Entity.Customer;


@Repository
public interface Customerrepository extends JpaRepository<Customer, Integer>{

}
