package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Vehicle;
import com.fleet.repo.VehicleRepo;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepo vehicleRepository;
	
	
	//return list of countries
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}
	
	//save new state
	
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		System.out.println("vehicle added successfully....");
	}
	
	//get by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	// delete by id
	public void delete(int id) {
       vehicleRepository.deleteById(id);
       System.out.println("vehicle deleted successfully....");
	}
}
