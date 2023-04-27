package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Contact;
import com.fleet.repo.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	
	//return list of countries
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	//save new state
	
	public void save(Contact contact) {
		contactRepository.save(contact);
		System.out.println("contact added successfully....");
	}
	
	//get by id
	public Optional<Contact> findById(Integer id) {
		return contactRepository.findById(id);
	}

	// delete by id
	public void delete(Integer id) {
       contactRepository.deleteById(id);
       System.out.println("contact deleted successfully....");
	}
}
