package com.example.Driver.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Driver.Entity.User;

@Repository
public interface Userrepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsernameAndPassword(String username, String password);





	 


	

	

}
