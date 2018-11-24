package com.example.Yogesh_Suresh_IoTLab_project.Services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Yogesh_Suresh_IoTLab_project.Models.Alert;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Reading;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Vehicle;
import com.example.Yogesh_Suresh_IoTLab_project.Repositories.AlertRepository;

@Service
public class AlertService {

	@Autowired
	private AlertRepository alertRepo;
	
	public void addAlert(Alert alert) {
		alertRepo.save(alert);
	}
	
	public void deleteAlert(int id) {
		alertRepo.deleteById(id);;
	}

	public void checkAlert(Vehicle vehicle, Reading reading) {
		// TO check alert parameter and flag if any 
		
		double lowFuelPercentage = 0.1 ; 
		int low = 32;
		int high = 36;
		int FL = reading.getFrontLeft();
		int FR = reading.getFrontRight(); 		
		int RL = reading.getRearLeft();
		int RR = reading.getRearRight();
		String vin = reading.getVin();
		String priority;
		
		if(reading.getEngineRpm() > vehicle.getRedlineRpm())
		{
			System.out.println("Overspeed alert");
			Alert alert = new Alert();
			priority = "HIGH";
			alert.setPriority(priority);
			alert.setVin(vin);
			alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
			addAlert(alert);
		}
		if (reading.getFuelVolume() < (vehicle.getMaxFuelVolume() * lowFuelPercentage )) {
			
			System.out.println("low fuel alert");
			Alert alert = new Alert();
			priority = "MEDIUM";
			alert.setPriority(priority);
			alert.setVin(vin);
			alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
			addAlert(alert);
		}
		if (FL < low || FL > high || FR < low || FR > high ||
			RL < low || RL > high || RR < low || RR > high	)
		{
			Alert alert = new Alert();
			priority = "LOW";
			alert.setPriority(priority);
			alert.setVin(vin);
			alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
			addAlert(alert);

		}
		
	}

	public List<Alert> getAlerts(String vin) {
		// TO fetch alerts by Vin 
		return alertRepo.findByVin(vin);
	}
	public List<Alert> getAlertsByPriority(String priority) {
		// TO fetch alerts by priority
		return alertRepo.findByPriority(priority);
	}

	public List<Alert> getAlertsByParameter(String priority, int timeInHours) {
		// TO fetch alerts by Priority and latest hours 
		Timestamp timestamp= new Timestamp(System.currentTimeMillis() - (timeInHours * 60 * 60 * 1000));
		return alertRepo.findByParamters(priority,timestamp);
	}
}
