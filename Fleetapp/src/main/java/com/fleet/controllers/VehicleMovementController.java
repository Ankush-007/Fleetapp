package com.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

	@GetMapping("/vehiclemovement")
	public String getVehicleMovements() {
		return "vehiclemovement";
	}
}
