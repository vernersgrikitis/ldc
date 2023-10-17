# vehicle is Rest API app 

Java 17, Maven, PostrgeSQL, Liquibase

Order to run this app you must download it from repository -> 
https://github.com/vernersgrikitis/vehicle.app.git and must have some IDE that supports Java compilation

You can run it , and start sending requests, I prefer Postman but you can use you prefer most ;)

Where you can save client
POST localhost:8080/save-client

Where you can save vehicle
POST localhost:8080/save-vehicle

Where you can get client by email
GET localhost:8080/{email}/data

Where you can change owner of vehicle
PUT localhost:8080/change-owner

Where you can delate all form DB
DELETE localhost:8080/delete-all

Where you can get vehicle history
GET localhost:8080/vehicle-history/{id}
