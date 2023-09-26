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
    @Column(name = "identity_number")
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    @OneToMany(mappedBy = "owner", cascade= CascadeType.ALL)
    private List<Vehicle> vehicles;


    public void addVehicle(Vehicle vehicle) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        vehicles.add(vehicle);
        vehicle.setOwner(this);
    }

}
