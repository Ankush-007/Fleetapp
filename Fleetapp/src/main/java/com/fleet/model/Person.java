package com.fleet.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	
	@Formula(value = "concat(firstname,'',lastname)")
	private String fullname;
	private String title;
	private String initials;
	private String socialSecurityNumber;
	private String gender;
	private String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name="countryid",insertable = false,updatable = false)
	private Country country;
	private Integer countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid",insertable = false,updatable = false)
	private State state;
	private Integer stateid;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;
	private String city;
	private String address;
	private String phone;
	private String email;
	private String photo;
	
	
	
	
	
}
