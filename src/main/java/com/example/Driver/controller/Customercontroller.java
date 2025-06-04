package com.example.Driver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Driver.DTO.CustomerDTO;

import com.example.Driver.Entity.Customer;
import com.example.Driver.service.Customerservice;

import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Customercontroller {
	public Customerservice customerservice;
	
	public Customercontroller(Customerservice customerservice) {
		this.customerservice = customerservice;
	}
	
	@PutMapping("/customer")
	public ResponseEntity<CustomerDTO> updateCustomer(
	        @ApiParam(value = "Updated customer data", required = true) @RequestBody CustomerDTO customerDTO) {

		CustomerDTO updateCustomer = customerservice.update(customerDTO);

	    if (updateCustomer != null) {
	        return ResponseEntity.ok(updateCustomer); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }// 404 Not Found
	    }
	    @PostMapping("/customer")
		public ResponseEntity<CustomerDTO> saveCustomer(
				@ApiParam(value = "Customer information to save", required = true) @RequestBody CustomerDTO customerDTO) {

	    	CustomerDTO result = customerservice.save(customerDTO);
			if (result != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 Created
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }// 500 Error
			}
	@GetMapping("/customer")
			public ResponseEntity<List<CustomerDTO>> customerList() {

				List<CustomerDTO> list = customerservice.findAll();

				if (list.isEmpty()) {
					return ResponseEntity.noContent().build(); // 204 No Content
				} else {
					return ResponseEntity.ok(list);} // 200 OK with driver data
				}
	@GetMapping("/customer/{id}")
				public ResponseEntity<CustomerDTO> getCustomerById(
						@ApiParam(value = "The ID of the customer to be retrieved", required = true) @PathVariable int id) {

		CustomerDTO customerDTO = customerservice.findById(id);

					if (customerDTO != null) {
						return ResponseEntity.ok(customerDTO); // 200 OK with driver data
					} else {
						return ResponseEntity.notFound().build();} // 404 Not Found
					}
		@DeleteMapping("/customer/{id}")
					public ResponseEntity<String> deleteCustomerById(
							@ApiParam(value = "The ID of the customer to delete", required = true) @PathVariable int id) {

						boolean deleted = customerservice.delete(id);

						if (deleted) {
							return ResponseEntity.ok("Driver deleted successfully");
						} else {
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found with ID: " + id);
						}
}}

