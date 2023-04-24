package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleModel;
import com.fleet.repo.VehicleModelRepo;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepo vehicleModelRepository;
	
	
	//return list of countries
	public List<VehicleModel> getVehicleModel(){
		return vehicleModelRepository.findAll();
	}
	
	//save new vehicleModel
	
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
		System.out.println("vehicleModel added successfully....");
	}
	
	//get by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	public void delete(int id) {
       vehicleModelRepository.deleteById(id);
       System.out.println("vehicleModel deleted successfully....");
	}
}
