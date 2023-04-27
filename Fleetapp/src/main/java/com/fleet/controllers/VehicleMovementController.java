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

import com.fleet.model.Supplier;
import com.fleet.model.Vehicle;
import com.fleet.model.VehicleMovement;
import com.fleet.services.SupplierService;
import com.fleet.services.VehicleMovementService;
import com.fleet.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleMovementService vehiclemovementService;
	
	@GetMapping("/vehiclemovement")
	public String getVehicleMovement(Model model) {
		
		List<Vehicle> vehicleList=vehicleService.getVehicles();
		model.addAttribute("vehicle", vehicleList);
		
		List<Supplier> supplierList=supplierService. getSuppliers();
		model.addAttribute("supplier", supplierList);
		
		List<VehicleMovement> vehiclemovementList=vehiclemovementService. getVehicleMovements();
		model.addAttribute("vehiclemovement", vehiclemovementList);
		
		return "vehiclemovement";
	}
	
	@PostMapping("/vehiclemovement/addNew")
	public String addNew(VehicleMovement vehiclemovement) {
		vehiclemovementService.save(vehiclemovement);
		return "redirect:/vehiclemovement";
	}
	
	@RequestMapping("/vehiclemovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findByID(Integer id) {
	  return vehiclemovementService.findById(id);
	}
	
	
	@RequestMapping(value="/vehiclemovement/update",method = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMovement vehiclemovement) {
		vehiclemovementService.save(vehiclemovement);
		return "redirect:/vehiclemovement";
	}
	

	
	 @RequestMapping(value = "/vehiclemovement/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") Integer id, Model model) {
		 vehiclemovementService.delete(id);
		    return "redirect:/vehiclemovement";
	    }
}
