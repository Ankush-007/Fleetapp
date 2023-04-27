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
import com.fleet.model.Supplier;
import com.fleet.services.CountryService;
import com.fleet.services.StateService;
import com.fleet.services.SupplierService;

@Controller
public class SupplierController {


	

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/supplier")
	public String getSuppliers(Model model) {
		
		List<Supplier> supplierList=supplierService.getSuppliers();
		model.addAttribute("supplier", supplierList);
		
		List<Country> countryList=countryService. getCountries();
		model.addAttribute("country", countryList);
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state", stateList);
		
		return "supplier";
	}
	
	@PostMapping("/supplier/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findByID(Integer id) {
	  return supplierService.findById(id);
	}
	
	
	@RequestMapping(value="/supplier/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	

	
	 @RequestMapping(value = "/supplier/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") Integer id, Model model) {
		 supplierService.delete(id);
		    return "redirect:/supplier";
	    } 
	
}
