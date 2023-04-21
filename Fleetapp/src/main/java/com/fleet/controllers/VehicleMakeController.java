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
import com.fleet.model.VehicleMake;
import com.fleet.model.State;
import com.fleet.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehiclemake")
	public String getVehicleMake(Model model) {
		
		List<VehicleMake> vehicleMakeList=vehicleMakeService. getVehicleMake();
		model.addAttribute("vehicleMake", vehicleMakeList);
		
		return "vehiclemake";
	}
	
	@PostMapping("/vehiclemake/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
	@RequestMapping("/vehiclemake/findById")
	@ResponseBody
	public Optional<VehicleMake> findByID(int id) {
	  return vehicleMakeService.findById(id);
	}
	
	
	@RequestMapping(value="/vehiclemake/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemake";
	}
	

	
	 @RequestMapping(value = "/vehicleMake/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 vehicleMakeService.delete(id);
		    return "redirect:/vehicleMake";
	    }
}
