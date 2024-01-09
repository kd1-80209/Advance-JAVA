package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
