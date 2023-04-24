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
import com.fleet.model.VehicleType;
import com.fleet.model.State;
import com.fleet.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicletype")
	public String getVehicleType(Model model) {
		
		List<VehicleType> vehicleTypeList=vehicleTypeService. getVehicleType();
		model.addAttribute("vehicleType", vehicleTypeList);
		
		return "vehicletype";
	}
	
	@PostMapping("/vehicletype/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicletype";
	}
	
	@RequestMapping("/vehicletype/findById")
	@ResponseBody
	public Optional<VehicleType> findByID(int id) {
	  return vehicleTypeService.findById(id);
	}
	
	
	@RequestMapping(value="/vehicletype/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicletype";
	}
	

	
	 @RequestMapping(value = "/vehicletype/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 vehicleTypeService.delete(id);
		    return "redirect:/vehicletype";
	    }
}
