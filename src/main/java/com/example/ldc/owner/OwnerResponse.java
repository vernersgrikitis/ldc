package com.example.ldc.owner;

import com.example.ldc.vehicle.Vehicle;

import java.util.List;
import java.util.Objects;


public class OwnerResponse {

    private String identityNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private List<Vehicle> vehicles;

    public OwnerResponse(String identityNumber, String firstName, String lastName, String address, String email, List<Vehicle> vehicles) {
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.vehicles = vehicles;
    }

    public OwnerResponse() {
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerResponse that = (OwnerResponse) o;
        return Objects.equals(identityNumber, that.identityNumber) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(vehicles, that.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityNumber, firstName, lastName, address, email, vehicles);
    }

    @Override
    public String toString() {
        return "OwnerResponse{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
