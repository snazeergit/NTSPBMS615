package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {

	private String companyName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate establishedDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime establishedTime;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime establishedOn;

	private List<Project> ongoingProjects;
}
