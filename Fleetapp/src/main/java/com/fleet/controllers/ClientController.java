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
import com.fleet.model.Client;
import com.fleet.model.State;
import com.fleet.services.CountryService;
import com.fleet.services.ClientService;
import com.fleet.services.StateService;

@Controller
public class ClientController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public String getClient(Model model) {
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("state", stateList);
		
		List<Country> countryList=countryService. getCountries();
		model.addAttribute("country", countryList);
		
		List<Client> clientList=clientService. getClients();
		model.addAttribute("client", clientList);
		
		return "client";
	}
	
	@PostMapping("/client/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findByID(int id) {
	  return clientService.findById(id);
	}
	
	
	@RequestMapping(value="/client/update",method = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	

	
	 @RequestMapping(value = "/client/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 clientService.delete(id);
		    return "redirect:/client";
	    }  
}
