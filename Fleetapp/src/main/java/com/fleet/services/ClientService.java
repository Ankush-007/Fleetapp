package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.Client;
import com.fleet.model.State;
import com.fleet.repo.ClientRepo;

@Service
public class ClientService {

	@Autowired
	private ClientRepo clientRepository;
	
	
	//return list of countries
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	//save new state
	
	public void save(Client client) {
		clientRepository.save(client);
		System.out.println("client added successfully....");
	}
	
	//get by id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}

	// delete by id
	public void delete(int id) {
       clientRepository.deleteById(id);
       System.out.println("client deleted successfully....");
	}

}
