package com.example.Driver.service;
import java.util.List;


import com.example.Driver.DTO.CustomerDTO;


public interface Customerservice {

	  
	
	  List<CustomerDTO> findAll();

	

	CustomerDTO findById(int id);

	boolean delete(int id);

	CustomerDTO update(CustomerDTO customerDTO);



	CustomerDTO save(CustomerDTO customerDTO);


		
	
}
