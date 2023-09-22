package com.example.ldc.owner;

import com.example.ldc.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @NonNull
    private String ownerIdentityNumber;
    @NonNull
    private String ownerFirstname;
    @NonNull
    private String ownerLastname;
    @NonNull
    private String ownerAddress;
    @NonNull
    private String ownerEmail;
    @NonNull
    @OneToMany(mappedBy = "owner", cascade= CascadeType.ALL)
    private List<Vehicle> vehicles;

}
