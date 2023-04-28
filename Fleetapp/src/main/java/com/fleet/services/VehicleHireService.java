package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleHire;
import com.fleet.repo.VehicleHireRepo;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepo vehicleHireRepository;
	
	
	//return list of countries
	public List<VehicleHire> getVehicleHire(){
		return vehicleHireRepository.findAll();
	}
	
	//save new vehicleHire
	
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
		System.out.println("vehicleHire added successfully....");
	}
	
	//get by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	public void delete(int id) {
       vehicleHireRepository.deleteById(id);
       System.out.println("vehicleHire deleted successfully....");
	}
}
