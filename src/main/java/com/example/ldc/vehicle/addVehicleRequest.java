package com.example.ldc.vehicle;

import com.example.ldc.owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class addVehicleRequest {

    @NonNull
    private String vinNumber;
    @NonNull
    private String registrationNumber;
    @NonNull
    private String manufacturer;
    @NonNull
    private String model;
    @NonNull
    private String fuel;
    @NonNull
    private String engineCapacity;
    @NonNull
    private Integer yearOfProduction;
    @NonNull
    private LocalDate vehicleRegistrationDate;
    @NonNull
    private Owner owner;
}
