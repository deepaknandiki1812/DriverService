package com.example.Driver.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.Driver.DTO.UserDTO;
import com.example.Driver.service.Userservice;

import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Usercontroller {
	public Userservice userservice;
	
	public Usercontroller(Userservice userservice) {
		this.userservice = userservice;
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserDTO> updateUser(
	        @ApiParam(value = "Updated user data", required = true) @RequestBody UserDTO userDTO) {

		UserDTO updateUser = userservice.update(userDTO);

	    if (updateUser != null) {
	        return ResponseEntity.ok(updateUser); // 200 OK
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }// 404 Not Found
	    }
	    @PostMapping("/user")
		public ResponseEntity<UserDTO> saveUser(
				@ApiParam(value = "User information to save", required = true) @RequestBody UserDTO userDTO) {

	    	UserDTO result = userservice.save(userDTO);
			if (result != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 Created
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }// 500 Error
			}
	    
	    
	    
	    @GetMapping("/user/login/{username}/{password}")
	    public ResponseEntity<Map> login(@PathVariable String username, @PathVariable String password) {
	    	String user = userservice.login(username, password);
	    	Map map = new HashMap();
	    	 map.put("message", user) ;

           return ResponseEntity.ok(map);
	    }
	 @GetMapping("/user")
			public ResponseEntity<List<UserDTO>> userList() {

				List<UserDTO> list = userservice.findAll();

				if (list.isEmpty()) {
					return ResponseEntity.noContent().build(); // 204 No Content
				} else {
					return ResponseEntity.ok(list);} // 200 OK with driver data
				}
	@GetMapping("/user/{id}")
				public ResponseEntity<UserDTO> getUserById(
						@ApiParam(value = "The ID of the user to be retrieved", required = true) @PathVariable int id) {

		UserDTO userDTO = userservice.findById(id);

					if (userDTO != null) {
						return ResponseEntity.ok(userDTO); // 200 OK with driver data
					} else {
						return ResponseEntity.notFound().build();} // 404 Not Found
					}
		@DeleteMapping("/user/{id}")
					public ResponseEntity<String> deleteUserById(
							@ApiParam(value = "The ID of the user to delete", required = true) @PathVariable int id) {

						boolean deleted = userservice.delete(id);

						if (deleted) {
							return ResponseEntity.ok("Driver deleted successfully");
						} else {
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found with ID: " + id);
						}
						
			
}}

