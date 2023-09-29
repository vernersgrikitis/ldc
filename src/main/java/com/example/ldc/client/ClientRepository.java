package com.example.ldc.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByEmail(String email);
    Optional<Client> getClientByIdentityNumber(String identity);
    boolean existsByEmail(String email);
    boolean existsByIdentityNumber(String identification);
}
