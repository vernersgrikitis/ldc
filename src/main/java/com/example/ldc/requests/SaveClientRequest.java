package com.example.ldc.requests;

import org.springframework.lang.NonNull;

public record SaveClientRequest(String firstName,
                                String lastName,
                                String email,
                                String address,
                                String identityNumber,
                                String dateOfBirth) {

    public SaveClientRequest(@NonNull String firstName,
                             @NonNull String lastName,
                             @NonNull String email,
                             @NonNull String address,
                             @NonNull String identityNumber,
                             @NonNull String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "SaveClientRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
