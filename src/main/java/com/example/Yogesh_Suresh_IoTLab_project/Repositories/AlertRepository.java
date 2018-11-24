package com.example.Yogesh_Suresh_IoTLab_project.Repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Yogesh_Suresh_IoTLab_project.Models.Alert;


public interface AlertRepository extends CrudRepository<Alert, Integer> {

	//To Fetch records by Vin column
	public List<Alert> findByVin(String vin);
	
	//To Fetch records by priorty column
	public List<Alert> findByPriority(String priority);
	
	
	//To Fetch records based on priority and Recent Timestamp
	@Query("SELECT alert FROM Alert alert WHERE alert.priority=:priority and alert.timestamp>=:timestamp")
	public List<Alert> findByParamters(@Param("priority") String p,@Param("timestamp") Timestamp t);
}