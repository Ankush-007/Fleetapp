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
import com.fleet.model.Location;
import com.fleet.model.State;
import com.fleet.services.CountryService;
import com.fleet.services.LocationService;
import com.fleet.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/location")
	public String getLocation(Model model) {
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state", stateList);
		
		List<Country> countryList=countryService. getCountries();
		model.addAttribute("country", countryList);
		
		List<Location> locationList=locationService. getLocation();
		model.addAttribute("location", locationList);
		
		return "location";
	}
	
	@PostMapping("/location/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findByID(int id) {
	  return locationService.findById(id);
	}
	
	
	@RequestMapping(value="/location/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	

	
	 @RequestMapping(value = "/location/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 locationService.delete(id);
		    return "redirect:/location";
	    } 
}
