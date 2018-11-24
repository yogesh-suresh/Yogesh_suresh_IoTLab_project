package com.example.Yogesh_Suresh_IoTLab_project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Yogesh_Suresh_IoTLab_project.Models.Vehicle;
import com.example.Yogesh_Suresh_IoTLab_project.Repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}
	
	public Optional<Vehicle> getVehicle(String vin) {
		return vehicleRepo.findByVin(vin);
	}
	
	public void deleteVehicle(int id) {
		vehicleRepo.deleteById(id);;
	}
	
	public void addAllVehicle(List<Vehicle> vehicles) {
		
		//Iterates over the list of vehicle objects for Upload
		
		for(Vehicle veh : vehicles) {
			Optional<Vehicle> optional = vehicleRepo.findByVin(veh.getVin());
		
		//To check if the Vehicle with Vin is already present
		
			if(optional.isPresent()) {
				Vehicle vehicle = optional.get();
				vehicle.setLastServiceDate(veh.getLastServiceDate());
				vehicle.setMake(veh.getMake());
				vehicle.setMaxFuelVolume(veh.getMaxFuelVolume());
				vehicle.setModel(veh.getModel());
				vehicle.setRedlineRpm(veh.getRedlineRpm());
				vehicle.setYear(veh.getYear());
				
				vehicleRepo.save(vehicle);
				System.out.println("Vehicle Details Updated for Id" + veh.getVin() );
			} else {
				vehicleRepo.save(veh);
				System.out.println("New Vehicle added");
			}
		}
		
		
	}

	public List<Vehicle> getAllVehicles() {
		// TO Fetch all vehicles 
		return (List<Vehicle>) vehicleRepo.findAll();
	}
}
