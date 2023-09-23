package com.example.ldc.owner;

import com.example.ldc.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    private String ownerIdentityNumber;
    private String ownerFirstname;
    private String ownerLastname;
    private String ownerAddress;
    private String ownerEmail;
    @OneToMany(mappedBy = "owner", cascade= CascadeType.ALL)
    private List<Vehicle> vehiclesList;

    public void addVehicle(Vehicle vehicle) {
        if (vehiclesList == null) {
            vehiclesList = new ArrayList<>();
        }
        vehiclesList.add(vehicle);
    }

}
