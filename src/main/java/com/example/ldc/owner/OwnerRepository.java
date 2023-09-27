package com.example.ldc.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends JpaRepository <Owner, String> {

    Owner findOwnerByIdentityNumber(String id);
}
