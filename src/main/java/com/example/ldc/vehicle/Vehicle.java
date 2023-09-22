package com.example.ldc.vehicle;

import com.example.ldc.owner.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle")
@Entity
public class Vehicle {

    @Id
    private String vinNumber;
    private String registrationNumber;
    private String manufacturer;
    private String model;
    private String fuel;
    private String engineCapacity;
    private int yearOfProduction;
    private LocalDateTime vehicleRegistrationDate;

    @ManyToOne
    @JoinColumn(name = "ownerIdentityNumber")
    private Owner owner;



}
