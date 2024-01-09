package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.DoctorNotFoundException;
import com.app.customexception.PatientNotFoundException;
import com.app.dto.AddAppointmentDTO;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.respository.AppointmentRepository;
import com.app.respository.DoctorRepository;
import com.app.respository.PatientRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointRepo;

	@Autowired
	private DoctorRepository docRepo;

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddAppointmentDTO addAppointment(AddAppointmentDTO newappoint) {

		Doctor doc = docRepo.findByFirstName(newappoint.getDocFirstName());

		Patient patient = patientRepo.findByFirstName(newappoint.getPFirstName());

		Appointment appointEntity = mapper.map(newappoint, Appointment.class);

		appointEntity.setDoctor(doc);
		appointEntity.setPatient(patient);
		return mapper.map(appointRepo.save(appointEntity), AddAppointmentDTO.class);

	}

}
