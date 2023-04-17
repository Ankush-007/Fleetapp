package com.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleModelController {

	@GetMapping("/vehiclemodel")
	public String getVehicleModels() {
		return "vehiclemodel";
	}
}
