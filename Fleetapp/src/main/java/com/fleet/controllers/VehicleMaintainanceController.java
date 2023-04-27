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

import com.fleet.model.VehicleMaintainance;
import com.fleet.model.Supplier;
import com.fleet.model.Vehicle;
import com.fleet.services.VehicleMaintainanceService;
import com.fleet.services.SupplierService;
import com.fleet.services.VehicleService;

@Controller
public class VehicleMaintainanceController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleMaintainanceService vehiclemaintainanceService;
	
	@GetMapping("/vehiclemaintainance")
	public String getVehicleMaintainance(Model model) {
		
		List<Vehicle> vehicleList=vehicleService.getVehicles();
		model.addAttribute("vehicle", vehicleList);
		
		List<Supplier> supplierList=supplierService. getSuppliers();
		model.addAttribute("supplier", supplierList);
		
		List<VehicleMaintainance> vehiclemaintainanceList=vehiclemaintainanceService. getVehicleMaintainances();
		model.addAttribute("vehiclemaintainance", vehiclemaintainanceList);
		
		return "vehiclemaintainance";
	}
	
	@PostMapping("/vehiclemaintainance/addNew")
	public String addNew(VehicleMaintainance vehiclemaintainance) {
		vehiclemaintainanceService.save(vehiclemaintainance);
		return "redirect:/vehiclemaintainance";
	}
	
	@RequestMapping("/vehiclemaintainance/findById")
	@ResponseBody
	public Optional<VehicleMaintainance> findByID(Integer id) {
	  return vehiclemaintainanceService.findById(id);
	}
	
	
	@RequestMapping(value="/vehiclemaintainance/update",method = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
	public String update(VehicleMaintainance vehiclemaintainance) {
		vehiclemaintainanceService.save(vehiclemaintainance);
		return "redirect:/vehiclemaintainance";
	}
	

	
	 @RequestMapping(value = "/vehiclemaintainance/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") Integer id, Model model) {
		 vehiclemaintainanceService.delete(id);
		    return "redirect:/vehiclemaintainance";
	    }
}
