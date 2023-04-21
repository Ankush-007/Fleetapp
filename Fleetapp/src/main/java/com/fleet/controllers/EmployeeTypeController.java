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
import com.fleet.model.EmployeeType;
import com.fleet.model.State;
import com.fleet.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeetype")
	public String getEmployeeType(Model model) {
		

		List<EmployeeType> employeeTypeList=employeeTypeService. getEmployeeType();
		model.addAttribute("employeeType", employeeTypeList);
		
		return "employeetype";
	}
	
	@PostMapping("/employeetype/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetype";
	}
	
	@RequestMapping("/employeetype/findById")
	@ResponseBody
	public Optional<EmployeeType> findByID(int id) {
	  return employeeTypeService.findById(id);
	}
	
	
	@RequestMapping(value="/employeetype/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeetype";
	}
	

	
	 @RequestMapping(value = "/employeetype/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 employeeTypeService.delete(id);
		    return "redirect:/employeetype";
	    }
}
