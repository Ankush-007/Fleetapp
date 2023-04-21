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

import com.fleet.model.InvoiceStatus;
import com.fleet.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoicestatus")
	public String getInvoiceStatus(Model model) {

		
		List<InvoiceStatus> invoiceStatusList=invoiceStatusService. getInvoiceStatus();
		model.addAttribute("invoiceStatus", invoiceStatusList);
		
		return "invoicestatus";
	}
	
	@PostMapping("/invoicestatus/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findByID(int id) {
	  return invoiceStatusService.findById(id);
	}
	
	
	@RequestMapping(value="/invoicestatus/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	

	
	 @RequestMapping(value = "/invoicestatus/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 invoiceStatusService.delete(id);
		    return "redirect:/invoicestatus";
	    }
}
