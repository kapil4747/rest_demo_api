package com.example.rest_demo_api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String firstName;
	
	private String surName;
	
	private LocalDate dateOfBirth;
	
	private LocalDate joiningDate;
	
	private Integer pincode;
	
	private Boolean softDelete;
	
	public UserEntity() {
		
	}

	public UserEntity(Integer id, String firstName, String surName, LocalDate dateOfBirth, LocalDate joiningDate,
			Integer pincode, Boolean softDelete) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
		this.pincode = pincode;
		this.softDelete = softDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Boolean getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(Boolean softDelete) {
		this.softDelete = softDelete;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", dateOfBirth="
				+ dateOfBirth + ", joiningDate=" + joiningDate + ", pincode=" + pincode + ", softDelete=" + softDelete
				+ "]";
	}
	
	
	
	
}
