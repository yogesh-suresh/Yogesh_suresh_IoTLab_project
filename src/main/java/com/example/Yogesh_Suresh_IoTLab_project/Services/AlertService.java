package com.example.Yogesh_Suresh_IoTLab_project.Services;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Yogesh_Suresh_IoTLab_project.Models.Alert;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Reading;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Vehicle;
import com.example.Yogesh_Suresh_IoTLab_project.Repositories.AlertRepository;
import static com.example.Yogesh_Suresh_IoTLab_project.Constants.Constants.*;

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
		
		int FL = reading.getFrontLeft();
		int FR = reading.getFrontRight(); 		
		int RL = reading.getRearLeft();
		int RR = reading.getRearRight();
		String vin = reading.getVin();
		
		if(reading.getEngineRpm() > vehicle.getRedlineRpm())
		{
			System.out.println("Overspeed alert");
			Alert alert = new Alert();
			alert.setPriority(HIGHPRIORITY);
			alert.setVin(vin);
			alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
			addAlert(alert);
		}
		if (reading.getFuelVolume() < (vehicle.getMaxFuelVolume() * LOWFUELPERCENTAGE )) {
			
			System.out.println("low fuel alert");
			Alert alert = new Alert();
			alert.setPriority(MEDIUMPRIORITY);
			alert.setVin(vin);
			alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
			addAlert(alert);
		}
		if (FL < LOWTIREPRES || FL > HIGHTIREPRES || FR < LOWTIREPRES || FR > HIGHTIREPRES ||
			RL < LOWTIREPRES || RL > HIGHTIREPRES || RR < LOWTIREPRES || RR > HIGHTIREPRES	)
		{
			Alert alert = new Alert();
			alert.setPriority(LOWPRIORITY);
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
