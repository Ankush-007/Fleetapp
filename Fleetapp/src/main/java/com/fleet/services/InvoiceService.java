package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Invoice;
import com.fleet.repo.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	//return list of countries
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}
	
	//save new invoice
	
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
		System.out.println("invoice added successfully....");
	}
	
	//get by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	public void delete(int id) {
       invoiceRepository.deleteById(id);
       System.out.println("invoice deleted successfully....");
	}
}
