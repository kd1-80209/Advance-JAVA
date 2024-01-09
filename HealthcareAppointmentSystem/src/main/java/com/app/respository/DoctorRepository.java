package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor findByFirstName(String docFirstName);

}
