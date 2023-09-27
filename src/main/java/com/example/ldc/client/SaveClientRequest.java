package com.example.ldc.client;

import org.springframework.lang.NonNull;

public record SaveClientRequest(String firstName,
                                String lastName,
                                String email,
                                String address,
                                String identityNumber) {

    public SaveClientRequest(@NonNull String firstName,
                             @NonNull String lastName,
                             @NonNull String email,
                             @NonNull String address,
                             @NonNull String identityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.identityNumber = identityNumber;
    }

    @Override
    public String toString() {
        return "SaveClientRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                '}';
    }
}
