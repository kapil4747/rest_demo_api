package com.example.rest_demo_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_demo_api.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserEntity user) {
		userRepository.save(user);
		return "save user";
	}
	
	@GetMapping("/all")
	public List<UserEntity> findAllUsers(){
		return (List<UserEntity>) userRepository.findAll();
	}
	
/*	@GetMapping("/firstName")
	public UserEntity findByfirstName(@PathVariable String firstName ) {
	         UserEntity firstname=userRepository.findByfirstName(firstName);
	    return firstname;
	} */
	
	@GetMapping("")
	public List<UserEntity> findByUserId(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) Integer pincode) {
		return userRepository.findByFirstNameOrSurNameOrPincode(firstName, lastName, pincode);
	}
	
	
	
	@PutMapping("/{id}")
	public UserEntity updateUser(@RequestBody UserEntity user,
			@PathVariable Integer id) {
		UserEntity userEntity = userRepository.findById(id).get();
				if(userEntity == null) {
					throw new RuntimeException("User not found with given id");
				}
		
		userEntity.setFirstName(user.getFirstName());
		userEntity.setSurName(user.getSurName());
		userEntity.setDateOfBirth(user.getDateOfBirth());
		userEntity.setJoiningDate(user.getJoiningDate());
		userEntity.setPincode(user.getPincode());
		return userRepository.save(userEntity);
	}
	
	@GetMapping("/findByDOB")
	public List<UserEntity> findByDOBSorted(){
		return userRepository.findByOrderByDateOfBirthAsc();
	}
	
	
	
	
	@DeleteMapping("/soft-delete/{id}")
	public void softDelete(@PathVariable Integer id) {
		UserEntity user = userRepository.findById(id).get();
		user.setSoftDelete(true);
	}
	
	
	
	
}
