package com.example.ldc.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    private String vinNumber;
    private String registrationNumber;
    private String manufacturer;
    private String model;
    private String fuel;
    private String engineCapacity;
    private Integer yearOfProduction;
    private LocalDateTime vehicleRegistrationDate;

    public Vehicle(String vinNumber, String registrationNumber, String manufacturer, String model, String fuel, String engineCapacity, Integer yearOfProduction, LocalDateTime vehicleRegistrationDate) {
        this.vinNumber = vinNumber;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuel = fuel;
        this.engineCapacity = engineCapacity;
        this.yearOfProduction = yearOfProduction;
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    public Vehicle() {
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public LocalDateTime getVehicleRegistrationDate() {
        return vehicleRegistrationDate;
    }

    public void setVehicleRegistrationDate(LocalDateTime vehicleRegistrationDate) {
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(vinNumber, vehicle.vinNumber) && Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(model, vehicle.model) && Objects.equals(fuel, vehicle.fuel) && Objects.equals(engineCapacity, vehicle.engineCapacity) && Objects.equals(yearOfProduction, vehicle.yearOfProduction) && Objects.equals(vehicleRegistrationDate, vehicle.vehicleRegistrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vinNumber, registrationNumber, manufacturer, model, fuel, engineCapacity, yearOfProduction, vehicleRegistrationDate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vinNumber='" + vinNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", vehicleRegistrationDate=" + vehicleRegistrationDate +
                '}';
    }
}
