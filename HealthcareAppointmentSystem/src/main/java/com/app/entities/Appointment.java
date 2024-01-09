package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment extends BaseEntity {

	@Column(name = "appoint_time")
	private LocalDateTime appointmentTime;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;

	public Appointment(LocalDateTime appointmentTime) {
		super();
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentTime=" + appointmentTime + "]";
	}

}
