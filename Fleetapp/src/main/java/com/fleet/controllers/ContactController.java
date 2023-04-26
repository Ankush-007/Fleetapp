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

import com.fleet.model.Contact;
import com.fleet.model.Country;
import com.fleet.model.State;
import com.fleet.services.ContactService;
import com.fleet.services.CountryService;
import com.fleet.services.StateService;

@Controller
public class ContactController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state", stateList);
		
		List<Country> countryList=countryService. getCountries();
		model.addAttribute("country", countryList);
		
		List<Contact> contactList=contactService. getContacts();
		model.addAttribute("contact", contactList);
		
		return "contact";
	}
	
	@PostMapping("/contact/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findByID(Integer id) {
	  return contactService.findById(id);
	}
	
	
	@RequestMapping(value="/contact/update",method = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	

	
	 @RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") Integer id, Model model) {
		 contactService.delete(id);
		    return "redirect:/contact";
	    }  
}
