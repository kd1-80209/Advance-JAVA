package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByFirstName(String pFirstName);

}
