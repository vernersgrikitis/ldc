package com.example.ldc.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequest {

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
}
