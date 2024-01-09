package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddAppointmentDTO;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin("http://localhost:3000")
public class AppointmentController {

	@Autowired
	private AppointmentService appointService;

	public AppointmentController() {
		System.out.println("in ctor of" + getClass());
	}

	@PostMapping
	public AddAppointmentDTO addNewAppoint(@RequestBody AddAppointmentDTO newappoint) {

		System.out.println("In Add New Appoint" + newappoint);

		return appointService.addAppointment(newappoint);

	}
}
