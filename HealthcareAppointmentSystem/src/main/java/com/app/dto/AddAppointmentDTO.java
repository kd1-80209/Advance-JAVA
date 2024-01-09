package com.app.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddAppointmentDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	private String pFirstName;

	private String docFirstName;

	private LocalDateTime appointmentTime;

}
