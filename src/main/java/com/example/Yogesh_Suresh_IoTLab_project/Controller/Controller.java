package com.example.Yogesh_Suresh_IoTLab_project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Yogesh_Suresh_IoTLab_project.Models.Alert;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Reading;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Vehicle;
import com.example.Yogesh_Suresh_IoTLab_project.Services.AlertService;
import com.example.Yogesh_Suresh_IoTLab_project.Services.VehicleService;

@RestController
public class Controller {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private AlertService alertService;
	
	//Endpoint to put bulk Vehicle details
	@CrossOrigin
	@PutMapping("/vehicles")
	public void putVechicle(@RequestBody List<Vehicle>  vehicles) {
		vehicleService.addAllVehicle(vehicles);
	}
	
	//Endpoint to ingest vehicle readings
	@CrossOrigin
	@PostMapping("/readings")
	public void postReadings(@RequestBody Reading reading) {
		System.out.println("New Reading");
		System.out.println(reading);
		
		Optional<Vehicle> optional = vehicleService.getVehicle(reading.getVin());
		if(optional.isPresent())
		{	Vehicle veh  = optional.get();
			alertService.checkAlert(veh,reading);
		}else
			System.out.println("Invalid Vin!!!!" + reading.getVin() );
	}
	
	//Endpoint to fetch all Vehicles
	@CrossOrigin
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicleDetails() {

		return vehicleService.getAllVehicles();
	}
	
	//Endpoint to fetch Alerts based on Vin
	@CrossOrigin
	@GetMapping("/getAlerts/{vin}")
	public List<Alert> getVehicleAlerts(@PathVariable String vin) {
		
		return alertService.getAlerts(vin);
	}
	
	//Endpoint to fetch Alerts based on Priority
	@CrossOrigin
	@GetMapping("/getAlertsPriority/{priority}")
	public List<Alert> getVehicleAlertsByPriority(@PathVariable String priority) {
		
		return alertService.getAlertsByPriority(priority);
	}
	
	//Endpoint to fetch Alerts based on Priority and Last hours
	@CrossOrigin
	@GetMapping("/getAlertsPara/{priority}/{timeInHours}")
	public List<Alert> getVehicleAlertsByPriority(@PathVariable("priority") String priority,@PathVariable("timeInHours") int timeInHours) {
		
		return alertService.getAlertsByParameter(priority,timeInHours);
	}
}
