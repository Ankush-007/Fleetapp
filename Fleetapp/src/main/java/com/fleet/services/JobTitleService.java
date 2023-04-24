package com.fleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.model.JobTitle;
import com.fleet.repo.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	
	//return list of countries
	public List<JobTitle> getJobTitle(){
		return jobTitleRepository.findAll();
	}
	
	//save new jobTitle
	
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		System.out.println("jobTitle added successfully....");
	}
	
	//get by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	public void delete(int id) {
       jobTitleRepository.deleteById(id);
       System.out.println("jobTitle deleted successfully....");
	}
}
