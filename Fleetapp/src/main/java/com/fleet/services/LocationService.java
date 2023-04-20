package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Location;

import com.fleet.repo.LocationRepository;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	
	//return list of countries
	public List<Location> getLocation(){
		return locationRepository.findAll();
	}
	
	//save new location
	
	public void save(Location location) {
		locationRepository.save(location);
		System.out.println("location added successfully....");
	}
	
	//get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(int id) {
       locationRepository.deleteById(id);
       System.out.println("location deleted successfully....");
	}
}
