package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.InvoiceStatus;
import com.fleet.repo.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	
	//return list of countries
	public List<InvoiceStatus> getInvoiceStatus(){
		return invoiceStatusRepository.findAll();
	}
	
	//save new invoiceStatus
	
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
		System.out.println("invoiceStatus added successfully....");
	}
	
	//get by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	public void delete(int id) {
       invoiceStatusRepository.deleteById(id);
       System.out.println("invoiceStatus deleted successfully....");
	}
}
