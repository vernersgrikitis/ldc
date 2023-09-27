package com.example.ldc.vehicle;

import com.example.ldc.owner.Owner;
import java.util.Objects;


public class AddVehicleRequest {


    private String vinNumber;
    private String registrationNumber;
    private String manufacturer;
    private String model;
    private String fuel;
    private String engineCapacity;
    private Integer yearOfProduction;
    private Owner owner;

    public AddVehicleRequest(String vinNumber, String registrationNumber, String manufacturer, String model, String fuel, String engineCapacity, Integer yearOfProduction, Owner owner) {
        this.vinNumber = vinNumber;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuel = fuel;
        this.engineCapacity = engineCapacity;
        this.yearOfProduction = yearOfProduction;
        this.owner = owner;
    }

    public AddVehicleRequest() {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddVehicleRequest that = (AddVehicleRequest) o;
        return Objects.equals(vinNumber, that.vinNumber) && Objects.equals(registrationNumber, that.registrationNumber) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(model, that.model) && Objects.equals(fuel, that.fuel) && Objects.equals(engineCapacity, that.engineCapacity) && Objects.equals(yearOfProduction, that.yearOfProduction) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinNumber, registrationNumber, manufacturer, model, fuel, engineCapacity, yearOfProduction, owner);
    }

    @Override
    public String toString() {
        return "AddVehicleRequest{" +
                "vinNumber='" + vinNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", owner=" + owner +
                '}';
    }
}
