package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.State;
import com.fleet.repo.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	
	//return list of countries
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	//save new state
	
	public void save(State state) {
		stateRepository.save(state);
		System.out.println("state added successfully....");
	}
	
	//get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	public void delete(int id) {
       stateRepository.deleteById(id);
       System.out.println("state deleted successfully....");
	}
}
