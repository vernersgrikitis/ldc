package com.example.ldc.requests;

import org.springframework.lang.NonNull;

public record ChangeOwnerRequest(String vinNumber, SaveClientRequest newOwner) {

    public ChangeOwnerRequest(@NonNull String vinNumber,
                              @NonNull SaveClientRequest newOwner) {
        this.vinNumber = vinNumber;
        this.newOwner = newOwner;
    }
}
