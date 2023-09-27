package com.example.ldc.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByIdentityNumber(String identification);
}
