package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleType;
import com.fleet.repo.VehicleTypeRepo;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepo vehicleTypeRepository;
	
	
	//return list of countries
	public List<VehicleType> getVehicleType(){
		return vehicleTypeRepository.findAll();
	}
	
	//save new vehicleType
	
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
		System.out.println("vehicleType added successfully....");
	}
	
	//get by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	public void delete(int id) {
       vehicleTypeRepository.deleteById(id);
       System.out.println("vehicleType deleted successfully....");
	}
}
