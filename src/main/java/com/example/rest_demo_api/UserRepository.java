package com.example.rest_demo_api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.rest_demo_api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	List<UserEntity> findByOrderByDateOfBirthAsc();
	

	
	List<UserEntity> findByFirstNameOrSurNameOrPincode(String firstName,
			String lastName,
			Integer pincode);



//	UserEntity findByfirstName(String firstName);



	
}
