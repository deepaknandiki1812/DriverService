package com.example.Driver.service;
import java.util.List;
import java.util.Optional;

import com.example.Driver.DTO.UserDTO;


public interface Userservice {

	  
	
	  List<UserDTO> findAll();

	UserDTO update(UserDTO userDTO);

	UserDTO save(UserDTO userDTO);

	UserDTO findById(int id);

	boolean delete(int id);

	String login(String username, String password);



		
	
}
