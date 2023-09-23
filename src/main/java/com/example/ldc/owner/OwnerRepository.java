package com.example.ldc.owner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository <Owner, String> {

    Optional<Owner> findOwnerByOwnerIdentityNumber(String Id);
}
