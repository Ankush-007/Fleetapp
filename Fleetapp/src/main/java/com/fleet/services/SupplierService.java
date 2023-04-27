package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Supplier;
import com.fleet.repo.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	
	//return list of countries
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	//save new supplier
	
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
		System.out.println("supplier added successfully....");
	}
	
	//get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	public void delete(int id) {
       supplierRepository.deleteById(id);
       System.out.println("supplier deleted successfully....");
	}
}
