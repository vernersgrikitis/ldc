package com.example.ldc.vehicle;

import com.example.ldc.owner.Owner;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "vehicle")
@Entity
public class Vehicle {

    @Id
    @Column(name = "vin_number")
    private String vinNumber;
    private String registrationNumber;
    private String manufacturer;
    private String model;
    private String fuel;
    private String engineCapacity;
    private int yearOfProduction;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "vehicle_registration_date")
    private LocalDateTime vehicleRegistrationDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Owner owner;

    public Vehicle(String vinNumber, String registrationNumber, String manufacturer, String model, String fuel, String engineCapacity, int yearOfProduction, LocalDateTime vehicleRegistrationDate, Owner owner) {
        this.vinNumber = vinNumber;
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuel = fuel;
        this.engineCapacity = engineCapacity;
        this.yearOfProduction = yearOfProduction;
        this.vehicleRegistrationDate = vehicleRegistrationDate;
        this.owner = owner;
    }

    public Vehicle() {
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

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public LocalDateTime getVehicleRegistrationDate() {
        return vehicleRegistrationDate;
    }

    public void setVehicleRegistrationDate(LocalDateTime vehicleRegistrationDate) {
        this.vehicleRegistrationDate = vehicleRegistrationDate;
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
        Vehicle vehicle = (Vehicle) o;
        return yearOfProduction == vehicle.yearOfProduction && Objects.equals(vinNumber, vehicle.vinNumber) && Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(model, vehicle.model) && Objects.equals(fuel, vehicle.fuel) && Objects.equals(engineCapacity, vehicle.engineCapacity) && Objects.equals(vehicleRegistrationDate, vehicle.vehicleRegistrationDate) && Objects.equals(owner, vehicle.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinNumber, registrationNumber, manufacturer, model, fuel, engineCapacity, yearOfProduction, vehicleRegistrationDate, owner);
    }

//    private String formatter(LocalDateTime vehicleRegistrationDate) {
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            return formatter.format(vehicleRegistrationDate);
//        } catch (Exception e) {
//            System.err.println("Error formatting date: " + e.getMessage());
//            return "Error";
//        }
//    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vinNumber='" + vinNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", vehicleRegistrationDate=" + vehicleRegistrationDate +
                ", owner=" + owner +
                '}';
    }


}
