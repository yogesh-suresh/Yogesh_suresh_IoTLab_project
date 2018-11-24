package com.example.Yogesh_Suresh_IoTLab_project.Models;

import java.sql.Timestamp;

//Class to map Reading JSON to Object for reference

public class Reading {

	private String vin;
	private long lattitude;
	private long longitude;
	private Timestamp timestamp;
	private float fuelVolume;
	private int speed;
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private long engineRpm;
	
	private Tires tires;
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public long getLattitude() {
		return lattitude;
	}

	public void setLattitude(long lattitude) {
		this.lattitude = lattitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public long getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(long engineRpm) {
		this.engineRpm = engineRpm;
	}
	
	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}
	
	public int getFrontLeft() {
		return getTires().getFrontLeft();
	}

	public int getFrontRight() {
		return getTires().getFrontRight();
	}

	public int getRearLeft() {
		return getTires().getRearLeft();
	}


	public int getRearRight() {
		return getTires().getRearRight();
	}

	public String toString() {
		return "Values--->>> vin =" + vin + 
				", lattitude =" + lattitude + ", longitude =" + longitude +
				", timestamp =" + timestamp + ", fuelVolume =" + fuelVolume + 
				", speed=" + speed + ", engineHp=" + engineHp + 
				", checkEngineLightOn=" + checkEngineLightOn + 
				", engineCoolantLow=" + engineCoolantLow +
				", cruiseControlOn=" + cruiseControlOn + 
				", engineRpm=" + engineRpm + 
				", frontRight=" + getFrontLeft() + ", frontLeft=" + getFrontRight() + 
				", RearLeft=" + getRearLeft() + ", rearRight=" + getRearRight() ;
	}

	
	
}
