package com.example.Driver.Mappers;

import org.springframework.stereotype.Component;

import com.example.Driver.DTO.CustomerDTO;

import com.example.Driver.Entity.Customer;

@Component
public class CustomerMapper {

	public Customer dtotoEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();

		customer.setAddress(customerDTO.getAddress());
		customer.setAge(customerDTO.getAge());
		customer.setarea(customerDTO.getarea());
		customer.setPension_id(customerDTO.getPension_id());
		customer.setContact(customerDTO.getContact());
		customer.setEmail(customerDTO.getEmail());
		customer.setId(customerDTO.getId());
		customer.setName(customerDTO.getName());
		

		return customer;
	}
	

	public CustomerDTO enitytoDto(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setAge(customer.getAge());
		customerDTO.setarea(customer.getarea());
		customerDTO.setPension_id(customer.getPension_id());
		customerDTO.setContact(customer.getContact());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setId(customer.getId());
		customerDTO.setName(customer.getName());
		

		return customerDTO;

	}

}
