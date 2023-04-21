package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleStatus;
import com.fleet.repo.VehicleStatusRepo;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepo vehicleStatusRepository;
	
	
	//return list of countries
	public List<VehicleStatus> getVehicleStatus(){
		return vehicleStatusRepository.findAll();
	}
	
	//save new vehicleStatus
	
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
		System.out.println("vehicleStatus added successfully....");
	}
	
	//get by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	public void delete(int id) {
       vehicleStatusRepository.deleteById(id);
       System.out.println("vehicleStatus deleted successfully....");
	}
}
