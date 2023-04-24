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
import com.fleet.model.JobTitle;
import com.fleet.model.State;
import com.fleet.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitle")
	public String getJobTitle(Model model) {

		
		List<JobTitle> jobTitleList=jobTitleService. getJobTitle();
		model.addAttribute("jobTitle", jobTitleList);
		
		return "jobtitle";
	}
	
	@PostMapping("/jobtitle/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitle";
	}
	
	@RequestMapping("/jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> findByID(int id) {
	  return jobTitleService.findById(id);
	}
	
	
	@RequestMapping(value="/jobtitle/update",method = {RequestMethod.PUT,RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitle";
	}
	

	
	 @RequestMapping(value = "/jobtitle/delete/{id}", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") int id, Model model) {
		 jobTitleService.delete(id);
		    return "redirect:/jobtitle";
	    }
}
