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

import com.fleet.model.Client;
import com.fleet.model.Invoice;
import com.fleet.model.InvoiceStatus;
import com.fleet.services.ClientService;
import com.fleet.services.InvoiceService;
import com.fleet.services.InvoiceStatusService;

@Controller
public class InvoiceController {


	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InvoiceStatusService invoicestatusService;
	
	@GetMapping("/invoice")
	public String getInvoices(Model model) {
		
		List<Invoice> invoiceList=invoiceService.getInvoices();
		model.addAttribute("invoice", invoiceList);
		
		List<Client> clientList=clientService. getClients();
		model.addAttribute("client", clientList);
		
		List<InvoiceStatus> invoicestatusList=invoicestatusService. getInvoiceStatus();
		model.addAttribute("invoicestatus", invoicestatusList);
		
		return "invoice";
	}
	
	@PostMapping("/invoice/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> findByID(int id) {
	  return invoiceService.findById(id);
	}
	
	
	@RequestMapping(value="/invoice/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	

	
	 @RequestMapping(value = "/invoice/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 invoiceService.delete(id);
		    return "redirect:/invoice";
	    } 
}
