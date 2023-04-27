package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.VehicleMaintainance;
import com.fleet.repo.VehicleMaintainanceRepo;

@Service
public class VehicleMaintainanceService {

	@Autowired
	private VehicleMaintainanceRepo vehiclemaintainanceRepository;
	
	
	//return list of countries
	public List<VehicleMaintainance> getVehicleMaintainances(){
		return vehiclemaintainanceRepository.findAll();
	}
	
	//save new state
	
	public void save(VehicleMaintainance vehiclemaintainance) {
		vehiclemaintainanceRepository.save(vehiclemaintainance);
		System.out.println("vehiclemaintainance added successfully....");
	}
	
	//get by id
	public Optional<VehicleMaintainance> findById(int id) {
		return vehiclemaintainanceRepository.findById(id);
	}

	// delete by id
	public void delete(int id) {
       vehiclemaintainanceRepository.deleteById(id);
       System.out.println("vehiclemaintainance deleted successfully....");
	}
}
