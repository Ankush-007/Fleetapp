package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleMake;
import com.fleet.repo.VehicleMakeRepo;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepo vehicleMakeRepository;
	
	
	//return list of countries
	public List<VehicleMake> getVehicleMake(){
		return vehicleMakeRepository.findAll();
	}
	
	//save new vehicleMake
	
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
		System.out.println("vehicleMake added successfully....");
	}
	
	//get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	public void delete(int id) {
       vehicleMakeRepository.deleteById(id);
       System.out.println("vehicleMake deleted successfully....");
	}
}
