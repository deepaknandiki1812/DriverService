package com.example.Driver.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Driver.DTO.CustomerDTO;
import com.example.Driver.Entity.Customer;

import com.example.Driver.Mappers.CustomerMapper;
import com.example.Driver.repository.Customerrepository;
import com.example.Driver.service.Customerservice;


@Service
public class Customerserviceimpl implements Customerservice{
	private Customerrepository customerrepository;
	private CustomerMapper customerMapper;
	
	public Customerserviceimpl(Customerrepository customerrepository,CustomerMapper customerMapper) {
		this.customerrepository=customerrepository;
		this.customerMapper=customerMapper;
	}

	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
				
		Customer customer =this.customerMapper.dtotoEntity(customerDTO);
		customer=customerrepository.save(customer);
		customerDTO=this.customerMapper.enitytoDto(customer);
		return customerDTO;
	}
	@Override
	public List<CustomerDTO> findAll() {
	    List<Customer> customers = customerrepository.findAll();
	   return customers.stream() 
	                  .map(customerMapper::enitytoDto)
	                  .collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> customerFound =customerrepository.findById(id);
		if(customerFound.isPresent()) {
			return this.customerMapper.enitytoDto(customerFound.get());
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
		customerrepository.deleteById(id);
		return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}



	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		 Customer existing = customerrepository.findById(customerDTO.getId()).orElse(null);
		 if (existing != null) {
		        existing.setAddress(customerDTO.getAddress());
		        existing.setAge(customerDTO.getAge());
		        existing.setarea(customerDTO.getarea());
		        existing.setPension_id(customerDTO.getPension_id());
		        existing.setContact(customerDTO.getContact());
		        existing.setEmail(customerDTO.getEmail());
		        existing.setId(customerDTO.getId());
		        existing.setName(customerDTO.getName());
		        customerrepository.save(existing);
		        return customerDTO;
		    } else {
		return null;
	}

	}}

