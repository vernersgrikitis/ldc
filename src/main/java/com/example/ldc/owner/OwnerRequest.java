package com.example.ldc.owner;

import java.util.Objects;

public class OwnerRequest {

    private String identityNumber;

    public OwnerRequest(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public OwnerRequest() {
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerRequest that = (OwnerRequest) o;
        return Objects.equals(identityNumber, that.identityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityNumber);
    }

    @Override
    public String toString() {
        return "OwnerRequest{" +
                "identityNumber='" + identityNumber + '\'' +
                '}';
    }
}
