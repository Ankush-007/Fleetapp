package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleMovement;
import com.fleet.repo.VehicleMovementRepo;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepo vehiclemovementRepository;
	
	
	//return list of countries
	public List<VehicleMovement> getVehicleMovements(){
		return vehiclemovementRepository.findAll();
	}
	
	//save new state
	
	public void save(VehicleMovement vehiclemovement) {
		vehiclemovementRepository.save(vehiclemovement);
		System.out.println("vehiclemovement added successfully....");
	}
	
	//get by id
	public Optional<VehicleMovement> findById(int id) {
		return vehiclemovementRepository.findById(id);
	}

	// delete by id
	public void delete(int id) {
       vehiclemovementRepository.deleteById(id);
       System.out.println("vehiclemovement deleted successfully....");
	}
}
