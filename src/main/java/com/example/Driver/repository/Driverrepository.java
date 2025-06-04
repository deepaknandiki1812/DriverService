package com.example.Driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Driver.Entity.Driver;

@Repository
public interface Driverrepository extends JpaRepository<Driver, Integer>{

}
