package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "patients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient extends BaseEntity {

	@Column(length = 30, unique = true)
	private String firstName;

	@Column(length = 30)
	private String lastName;

	@Column(name = "mob_no")
	private long mobileNo;
}
