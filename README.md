# VehicleRulesViolation
Project includes two Microservices written in spring boot. One is for customer and other one is for police. This project ultimately tell police the violation done by vehicle owner by sending an alert to police portal

This project include the backend endpoints written in java. So that the front end portal will use this endpoints to build front end part.

Once the Sensor found any violation done by any vehicle owner in the signal, the sensor will read the vehicle registration number and call the api written in backend java with that registration number, this api will get all the violation done under that registration number from the police database and send an alert to the police portal via websocke. So that police at the signal will come to know the violations

Assumption part- Only backend part is developed and front end part will be using the all endpoints present in backend to build police an dcustomer portals
