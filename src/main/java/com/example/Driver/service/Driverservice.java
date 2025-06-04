package com.example.Driver.service;
import java.util.List;
import java.util.Optional;

import com.example.Driver.DTO.DriverDTO;
import com.example.Driver.Entity.Driver;

public interface Driverservice {

	  DriverDTO save(DriverDTO driverDTO) ;
	
	  List<DriverDTO> findAll();

	  DriverDTO findById(int id);

	boolean delete(int id);

	DriverDTO update(DriverDTO driverDTO); 
		
	
}
