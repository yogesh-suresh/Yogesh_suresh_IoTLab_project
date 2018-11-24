package com.example.Yogesh_Suresh_IoTLab_project.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.Yogesh_Suresh_IoTLab_project.Models.Vehicle;


public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
	
	//To Fetch records by Vin column
	public Optional<Vehicle> findByVin(String id);

}