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
import com.fleet.model.VehicleModel;
import com.fleet.model.State;
import com.fleet.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehiclemodel")
	public String getVehicleModel(Model model) {

		List<VehicleModel> vehicleModelList=vehicleModelService. getVehicleModel();
		model.addAttribute("vehicleModel", vehicleModelList);
		
		return "vehiclemodel";
	}
	
	@PostMapping("/vehiclemodel/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	
	@RequestMapping("/vehiclemodel/findById")
	@ResponseBody
	public Optional<VehicleModel> findByID(int id) {
	  return vehicleModelService.findById(id);
	}
	
	
	@RequestMapping(value="/vehiclemodel/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	

	
	 @RequestMapping(value = "/vehiclemodel/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 vehicleModelService.delete(id);
		    return "redirect:/vehiclemodel";
	    }
}
