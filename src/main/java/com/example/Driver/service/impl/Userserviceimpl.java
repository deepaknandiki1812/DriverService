package com.example.Driver.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Driver.DTO.UserDTO;

import com.example.Driver.Entity.User;
import com.example.Driver.Mappers.UserMapper;

import com.example.Driver.repository.Userrepository;

import com.example.Driver.service.Userservice;



@Service
public class Userserviceimpl implements Userservice{
	private Userrepository userrepository;
	private UserMapper userMapper;
	
	
	public Userserviceimpl(Userrepository userrepository,UserMapper userMapper) {
		this.userrepository=userrepository;
		this.userMapper=userMapper;
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> users = userrepository.findAll();
		   return users.stream() 
		                  .map(userMapper::enitytoDto)
		                  .collect(Collectors.toList());
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user =this.userMapper.dtotoEntity(userDTO);
		user=userrepository.save(user);
		userDTO=this.userMapper.enitytoDto(user);
		return userDTO;
	}
	

	@Override
	public UserDTO findById(int id) {
		Optional<User> userFound =userrepository.findById(id);
		if(userFound.isPresent()) {
			return this.userMapper.enitytoDto(userFound.get());
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
			userrepository.deleteById(id);
			return true;
			}
			catch(Exception e) {
				return false;
			}
	}
	@Override
	public UserDTO update(UserDTO userDTO) {
		 User existing = userrepository.findById(userDTO.getId()).orElse(null);
		 if (existing != null) {
		        existing.setFirstname(userDTO.getFirstname());
		        existing.setLastname(userDTO.getLastname());
		        existing.setEmail(userDTO.getEmail());
		        existing.setAddress(userDTO.getAddress());
		        existing.setId(userDTO.getId());
		        existing.setContact(userDTO.getContact());
		        existing.setUsername(userDTO.getUsername());
		        existing.setPassword(userDTO.getPassword());
		        userrepository.save(existing);
		        return userDTO;
		    } else {
		return null;}}

	@Override
	public String login(String username, String password) {
		Optional<User> userFound =userrepository.findByUsernameAndPassword(username,password);
		if(userFound.isPresent()) {
			  return "SUCCESS";
	    } else {
	        return "FAILURE";
	    }
		
	}
}
	  