package com.example.ldc.owner;

import com.example.ldc.vehicle.Vehicle;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @Column(name = "identity_number")
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
//    @ToStringExclude
//    @OneToMany(mappedBy = "owner", cascade= CascadeType.ALL)
//    private List<Vehicle> vehicles;

    public Owner(String identityNumber, String firstName, String lastName, String address, String email, List<Vehicle> vehicles) {
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
//        this.vehicles = vehicles;
    }

    public Owner() {
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

//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        if (vehicles == null) {
//            vehicles = new ArrayList<>();
//        }
//        vehicles.add(vehicle);
//        vehicle.setOwner(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(identityNumber, owner.identityNumber) && Objects.equals(firstName, owner.firstName) && Objects.equals(lastName, owner.lastName) && Objects.equals(address, owner.address) && Objects.equals(email, owner.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityNumber, firstName, lastName, address, email);
    }


//    private String getVehicles(List<Vehicle> list) {
//        return list.stream().toString();
//    }

    @Override
    public String toString() {
        return "Owner{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
//                ", vehicles=" + getVehicles(vehicles) +
                '}';
    }
}
