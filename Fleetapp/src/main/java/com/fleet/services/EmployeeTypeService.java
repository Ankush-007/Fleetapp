package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.EmployeeType;
import com.fleet.repo.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	
	//return list of countries
	public List<EmployeeType> getEmployeeType(){
		return employeeTypeRepository.findAll();
	}
	
	//save new employeeType
	
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
		System.out.println("employeeType added successfully....");
	}
	
	//get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(int id) {
       employeeTypeRepository.deleteById(id);
       System.out.println("employeeType deleted successfully....");
	}
}
