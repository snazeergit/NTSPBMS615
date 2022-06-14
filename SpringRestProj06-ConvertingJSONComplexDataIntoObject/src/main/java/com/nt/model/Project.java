package com.nt.model;

import lombok.Data;

@Data
public class Project {
	private String projectName;
	private Integer durationInMonths;
	private Integer teamSize;
}
