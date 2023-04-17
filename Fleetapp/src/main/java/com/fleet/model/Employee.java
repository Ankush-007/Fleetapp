package com.fleet.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fleet.model.EmployeeType;
import com.fleet.model.Person;
import com.fleet.model.VehicleType;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Employee extends Person {

	@ManyToOne
    @JoinColumn(name="employeetypeid",insertable = false,updatable = false)
    private EmployeeType employeeType;
	private Integer employeetypeid;
	private String photo;
	private String username;
	
	@ManyToOne
    @JoinColumn(name="employeetypeid",insertable = false,updatable = false)
    private  JobTitle jobTitle;
	private Integer jobtitleid;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date hiredate;
	
	
	
}
