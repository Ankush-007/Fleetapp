package com.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintainanceController {

	@GetMapping("/vehiclemaintainance")
	public String getVehicleMaintainances() {
		System.out.println("hello");
		return "vehiclemaintainance";
	}
}
