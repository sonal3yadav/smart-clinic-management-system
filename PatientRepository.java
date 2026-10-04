package com.project.backend.repositories;

import com.project.backend.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Retrieves patient by email
    Optional<Patient> findByEmail(String email);

    // Retrieves patient using either email or phone number
    @Query("SELECT p FROM Patient p WHERE p.email = :email OR p.phone = :phone")
    Optional<Patient> findByEmailOrPhone(
            @Param("email") String email,
            @Param("phone") String phone);
}
