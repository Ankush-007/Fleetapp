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

import com.fleet.model.VehicleHire;
import com.fleet.services.ClientService;
import com.fleet.services.LocationService;
import com.fleet.services.VehicleHireService;
import com.fleet.services.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ClientService clientService;
	
	
	
	
	
	
	@GetMapping("/vehiclehire")
	public String getVehicleHire(Model model) {
		
		model.addAttribute("vehicleHire", vehicleHireService. getVehicleHire());
		model.addAttribute("vehicle", vehicleService. getVehicles());
		model.addAttribute("location", locationService. getLocation());
		model.addAttribute("client", clientService. getClients());
		
		return "vehiclehire";
	}
	
	@PostMapping("/vehiclehire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	@RequestMapping("/vehiclehire/findById")
	@ResponseBody
	public Optional<VehicleHire> findByID(int id) {
	  return vehicleHireService.findById(id);
	}
	
	
	@RequestMapping(value="/vehiclehire/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	

	
	 @RequestMapping(value = "/vehiclehire/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 vehicleHireService.delete(id);
		    return "redirect:/vehiclehire";
	    }
}
