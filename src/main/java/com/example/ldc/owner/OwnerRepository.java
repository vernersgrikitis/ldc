package com.example.ldc.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OwnerRepository extends JpaRepository <Owner, String> {

    Optional<Owner> findOwnerByIdentityNumber(String Id);

}
