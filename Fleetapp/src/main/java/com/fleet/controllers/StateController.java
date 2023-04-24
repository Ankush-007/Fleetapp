package com.fleet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.model.Country;
import com.fleet.model.State;
import com.fleet.services.CountryService;
import com.fleet.services.StateService;


@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/state")
	public String getStates(Model model) {
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state", stateList);
		
		List<Country> countryList=countryService. getCountries();
		model.addAttribute("country", countryList);
		
		return "state";
	}
	
	@PostMapping("/state/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	
	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> findByID(int id) {
	  return stateService.findById(id);
	}
	
	
	@RequestMapping(value="/state/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/state";
	}
	

	
	 @RequestMapping(value = "/state/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 stateService.delete(id);
		    return "redirect:/state";
	    } 
}
