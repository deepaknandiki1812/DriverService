package com.example.Driver.Mappers;

import org.springframework.stereotype.Component;

import com.example.Driver.DTO.UserDTO;

import com.example.Driver.Entity.User;


@Component
public class UserMapper {

	public User dtotoEntity(UserDTO userDTO) {
		User user = new User();

		user.setAddress(userDTO.getAddress());
		user.setContact(userDTO.getContact());
		user.setEmail(userDTO.getEmail());
		user.setFirstname(userDTO.getFirstname());
		user.setId(userDTO.getId());
		user.setLastname(userDTO.getLastname());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		

		return user;
	}
	

	public UserDTO enitytoDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(user.getAddress());
		userDTO.setContact(user.getContact());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setId(user.getId());
		userDTO.setLastname(user.getLastname());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		

		return userDTO;

	}

}
