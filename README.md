# Yogesh_suresh_IoTLab_project

Heroku Link : - https://yogesh-suresh-iotlab-project.herokuapp.com

Please allow  few seconds for site to load  as the heroku will invocate the required application 

Design and Archietecture in Design Folder

Tools Required to Test the Implementation 
1) MySQL Workbench (Credentials are in the Mail)
2) Browser with JSON formatted or Postman to View response formatted

REST Endpoints: -

1) To bulk load vehicle details https://yogesh-suresh-iotlab-project.herokuapp.com/vehicles

2) To Post readings https://yogesh-suresh-iotlab-project.herokuapp.com/readings

3) To fetch details of all vehicle https://yogesh-suresh-iotlab-project.herokuapp.com/getAllVehicles

4) To fetch alerts for given (vin) https://yogesh-suresh-iotlab-project.herokuapp.com/getAlerts/{vin}

5) To fetch alerts with parameter 
https://yogesh-suresh-iotlab-project.herokuapp.com/getAlertsPara/{priority}/{timeInHours}

  For HIGH alerts for last 2 hours
  eg. https://yogesh-suresh-iotlab-project.herokuapp.com/getAlertsPara/HIGH/2

6) To fetch alerts with priority 
https://yogesh-suresh-iotlab-project.herokuapp.com/getAlertsPriority/{priority}

  For all MEDIUM alerts 
  eg. https://yogesh-suresh-iotlab-project.herokuapp.com/getAlertsPriority/MEDIUM
